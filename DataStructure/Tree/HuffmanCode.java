package com.Tree;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

/**
 * @ JieWang
 * @date 2020/9/5 - 11:48
 */
public class HuffmanCode {
    public static void main(String[] args) throws IOException {
        /*String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length); // 40

        byte[] bytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果是:" + Arrays.toString(bytes) + " 长度= " + bytes.length);

        byte[] deCode = deCode(bytes, huffmanCode);
        System.out.println(new String(deCode));*/

        /*ArrayList<Nodes> nodes = tobeList(contentBytes);
        System.out.println(nodes);

        Nodes root = creatHuffmanTree(nodes);
        preOrder(root);

        getCode(root);
        System.out.println("nodes: " + huffmanCode);

        byte[] zip = zip(contentBytes, huffmanCode);
        System.out.println(Arrays.toString(zip));*/

        /*// 文件压缩测试
        String srcfile = "E:\\Google\\C.png";
        String dstfile = "E:\\Google\\D.zip";
        zipFile(srcfile, dstfile);
        System.out.println("the zip file is success");*/

        // 文件解压测试
        String zipFile = "E:\\Google\\D.zip";
        String dstFile = "E:\\Google\\e.png";
        unzipFile(zipFile, dstFile);
        System.out.println("解压成功!");
    }

    /**
     *
     * @param srcFile 压缩文件地址
     * @param dstFile 解压缩文件地址
     */
    private static void unzipFile(String srcFile, String dstFile) {
        //定义文件输入流
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        OutputStream os = null;
        try {
            //创建文件输入流
            is = new FileInputStream(srcFile);
            //创建一个和  is关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组  huffmanBytes
            byte[] huffmanBytes = (byte[])ois.readObject();
            //读取赫夫曼编码表
            Map<Byte,String> huffmanCodes = (Map<Byte,String>)ois.readObject();

            //解码
            byte[] bytes = deCode(huffmanBytes, huffmanCodes);
            //将bytes 数组写入到目标文件
            os = new FileOutputStream(dstFile);
            //写数据到 dstFile 文件
            os.write(bytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

            try {
                os.close();
                ois.close();
                is.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    /**
     * @param scrFile 源文件地址
     * @param dstFile 压缩文件地址
     * @throws IOException 抛出异常
     */
    public static void zipFile(String scrFile, String dstFile){
        //创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        //创建文件的输入流
        FileInputStream is = null;
        try {
            //创建文件的输入流
            is = new FileInputStream(scrFile);
            //创建一个和源文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //直接对源文件压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件的输出流, 存放压缩文件
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //把 赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes); //我们是把
            //这里我们以对象流的方式写入 赫夫曼编码，是为了以后我们恢复源文件时使用
            //注意一定要把赫夫曼编码 写入压缩文件
            oos.writeObject(huffmanCode);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                is.close();
                oos.close();
                os.close();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    //完成数据的解压
    //思路
    //1. 将huffmanCodeBytes [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
    //   重写先转成 赫夫曼编码对应的二进制的字符串 "1010100010111..."
    //2.  赫夫曼编码对应的二进制的字符串 "1010100010111..." =》 对照 赫夫曼编码  =》 "i like like like java do you like a java"
    //编写一个方法，完成对压缩数据的解码

    /**
     * @param huffmanCodes 赫夫曼编码表 map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
     */
    private static byte[] deCode(byte[] huffmanBytes, Map<Byte, String> huffmanCodes) {
        //1. 先得到 huffmanBytes 对应的 二进制的字符串 ， 形式 1010100010111...
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteTobinString(!flag, b));
        }
        //把字符串安装指定的赫夫曼编码进行解码
        //把赫夫曼编码表进行调换，因为反向查询 a->100 100->a
        Map<String, Byte> map = new HashMap<String, Byte>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        //创建要给集合，存放byte
        List<Byte> list = new ArrayList<>();
        //i 可以理解成就是索引,扫描 stringBuilder
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1; // 小的计数器
            boolean flag = true;
            Byte b = null;

            while (flag) {
                //1010100010111...
                //递增的取出 key 1
                String key = stringBuilder.substring(i, i + count);//i 不动，让count移动，指定匹配到一个字符
                b = map.get(key);
                if (b == null) {//说明没有匹配到
                    count++;
                } else {
                    //匹配到
                    flag = false;
                }
            }
            list.add(b);
            i += count;//i 直接移动到 count
        }
        //当for循环结束后，我们list中就存放了所有的字符  "i like like like java do you like a java"
        //把list 中的数据放入到byte[] 并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * function: translation a byte data to a String
     *
     * @param flag 判断是否需要补高位，如果是true ，表示需要补高位，如果是false表示不补, 如果是最后一个字节，无需补高位
     * @param b    传入的字节数据
     * @return 是该 b 对应的二进制的字符串（注意是按补码返回）
     */
    private static String byteTobinString(boolean flag, byte b) {
        //使用变量保存 b
        int temp = b; //将 b 转成 int
        //如果是正数我们还存在补高位
        if (flag) {
            temp |= 256; //按位与 256  1 0000 0000  | 0000 0001 => 1 0000 0001
        }
        String str = Integer.toBinaryString(temp); //返回的是temp对应的二进制的补码
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    //编写一个方法，将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]
    private static byte[] huffmanZip(byte[] bytes) {
        // 构造一个集合
        ArrayList<Nodes> nodes = tobeList(bytes);
        // 根据 nodes 创建的赫夫曼树
        Nodes root = creatHuffmanTree(nodes);
        //对应的赫夫曼编码(根据 赫夫曼树)
        Map<Byte, String> code = getCode(root);
        //根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        byte[] zip2 = zip(bytes, huffmanCode);
        return zip2;
    }

    //编写一个方法，将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]

    /**
     * @param bytes        这时原始的字符串对应的 byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的 byte[]
     * 举例： String content = "i like like like java do you like a java"; =》 byte[] contentBytes = content.getBytes();
     * 返回的是 字符串 "1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100"
     * => 对应的 byte[] huffmanCodeBytes  ，即 8位对应一个 byte,放入到 huffmanCodeBytes
     * huffmanCodeBytes[0] =  10101000(补码) => byte  [推导  10101000=> 10101000 - 1 => 10100111(反码)=> 11011000= -88 ]
     * huffmanCodeBytes[1] = -88
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffmanCode.get(b));
        }
        int len = (sb.length() + 7) / 8;
        byte[] bytes1 = new byte[len];
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String strByte;
            if (i + 8 > sb.length()) {
                strByte = sb.substring(i);
            } else {
                strByte = sb.substring(i, i + 8);
            }
            bytes1[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return bytes1;
    }

    //为了调用方便，我们重载 getCodes
    private static Map<Byte, String> getCode(Nodes root) {
        if (root == null) {
            return null;
        }
        getCode(root, sb, "");
        return huffmanCode;
    }

    //生成赫夫曼树对应的赫夫曼编码
    //思路:
    //1. 将赫夫曼编码表存放在 Map<Byte,String> 形式
    //   生成的赫夫曼编码表{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
    static StringBuilder sb = new StringBuilder();
    //2. 在生成赫夫曼编码表示，需要去拼接路径, 定义一个StringBuilder 存储某个叶子结点的路径
    static Map<Byte, String> huffmanCode = new HashMap<>();

    /**
     * 功能：将传入的 Nodes 节点的所有叶子节点的哈夫曼编码得到，并放入到 huffmanCode 中
     *
     * @param root 传入节点（一般就是根节点）
     * @param sb   用于拼接路径
     * @param code 路径：左子节点：0，右子节点：1
     */
    private static void getCode(Nodes root, StringBuilder sb, String code) {
        StringBuilder stringBuilder = new StringBuilder(sb);
        // 将 code 加入到 StringBuilder 中
        stringBuilder.append(code);
        if (root != null) {// 如果 node==null 不处理
            // 判断当前 root 是叶子节点还是非叶子节点
            if (root.data == null) {// 非叶子节点
                // 递归处理
                getCode(root.left, stringBuilder, "0");
                getCode(root.right, stringBuilder, "1");
            } else {//说明是一个叶子结点
                //就表示找到某个叶子结点的最后
                huffmanCode.put(root.data, stringBuilder.toString());
            }
        }
    }

    //前序遍历的方法
    private static void preOrder(Nodes root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("the tree is empty.");
        }
    }

    /**
     * @param bytes 接收的字节数组
     * @return 返回由 Nodes[Node[date=97 ,weight = 5], Node[]date=32,weight = 9]......] 构成的集合
     */
    public static ArrayList<Nodes> tobeList(byte[] bytes) {
        ArrayList<Nodes> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        Set<Map.Entry<Byte, Integer>> entries = counts.entrySet();
        for (Map.Entry<Byte, Integer> i : entries) {
            nodes.add(new Nodes(i.getKey(), i.getValue()));
        }
        return nodes;
    }

    //可以通过List 创建对应的赫夫曼树
    private static Nodes creatHuffmanTree(ArrayList<Nodes> array) {
        while (array.size() > 1) {
            Collections.sort(array);
            Nodes leftNode = array.get(0);
            Nodes rightNode = array.get(1);
            Nodes parent = new Nodes(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            array.remove(leftNode);
            array.remove(rightNode);
            array.add(parent);
        }
        return array.get(0);
    }
}

//创建Node ,待数据和权值
class Nodes implements Comparable<Nodes> {
    Byte data;// 存放数据(字符)本身，比如'a' => 97 ' ' => 32
    int weight;//权值, 表示字符出现的次数
    Nodes left;
    Nodes right;

    public Nodes(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Nodes{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Nodes o) {
        // 从小到大排序
        return this.weight - o.weight;
    }


    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
