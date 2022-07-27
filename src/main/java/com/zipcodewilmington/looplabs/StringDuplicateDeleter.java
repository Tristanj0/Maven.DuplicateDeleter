package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        Integer [] multiples = countMultiples(array);
        int finalArrayLength = calculateNewLength(multiples, maxNumberOfDuplications);
        String [] result = new String[finalArrayLength];
        int resultCount = 0;
        int multiplesCount = 0;
        int start = 0;
        int end = multiples[multiplesCount];
        while(multiplesCount < multiples.length) {
            for (int i = start; i < end; i++) {

                if (multiples[multiplesCount] < maxNumberOfDuplications) {
                    result[resultCount] = array[i];
                    resultCount++;
                }

            }
            start = start + multiples[multiplesCount];
            multiplesCount++;
            if(end != array.length){
                end = end + multiples[multiplesCount];
            }

        }
        return result;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer [] multiples = countMultiples(array);
        int finalArrayLength = calculateExactLength(multiples,exactNumberOfDuplications);
        String [] result = new String[finalArrayLength];
        int resultCount = 0;
        int multiplesCount = 0;
        int start = 0;
        int end = multiples[multiplesCount];
        while(multiplesCount < multiples.length) {
            for (int i = start; i < end; i++) {

                if (multiples[multiplesCount] != exactNumberOfDuplications) {
                    result[resultCount] = array[i];
                    resultCount++;
                }

            }
            start = start + multiples[multiplesCount];
            multiplesCount++;
            if(end != array.length){
                end = end + multiples[multiplesCount];
            }

        }
        return result;
    }

    @Override
    public Integer[] countMultiples(String[] input) {
        int countMultiples = 1;
        int numGroup = 1;
        int totalCount = 0;
        int start;
        Integer [] duplicates = new Integer[1];

        for(start = 0; start < input.length; start++){
            for(int j = start+1; j < input.length; j++){
                if(input[start].equals(input[j])){
                    countMultiples++;
                }
            }
            if (numGroup == 1){
                duplicates[0] = countMultiples;
                totalCount += countMultiples;
                start = totalCount-1;
                countMultiples = 1;
                numGroup++;
            }
            else {
                Integer [] larger = new Integer[duplicates.length+1];
                for(int a = 0; a < duplicates.length; a++){
                    larger[a] =duplicates[a];
                }
                larger[larger.length-1]=countMultiples;
                duplicates = new Integer[larger.length];
                duplicates = larger;
                totalCount += countMultiples;
                start = totalCount-1;
                countMultiples = 1;
            }
        }
        return duplicates;
    }

    @Override
    public int calculateNewLength(Integer[] multiples, int maxNumberOfDuplications) {
        int count = 0;
        for(int i = 0; i < multiples.length; i++){
            if(multiples[i] < maxNumberOfDuplications){
                count = count + multiples[i];
            }
        }
        return count;
    }

    @Override
    public int calculateExactLength(Integer[] multiples, int exactNumberOfDuplications) {
        int count = 0;
        for(int i = 0; i < multiples.length; i++){
            if(multiples[i] != exactNumberOfDuplications){
                count = count + multiples[i];
            }
        }
        return count;
    }
}
