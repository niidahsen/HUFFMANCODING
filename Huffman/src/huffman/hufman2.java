package huffman;

import java.util.Comparator;

/**
 *
 * @author niida
 */
public class hufman2 implements Comparator<HuffmanNode> {

    @Override
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.item - y.item;
    }

}
