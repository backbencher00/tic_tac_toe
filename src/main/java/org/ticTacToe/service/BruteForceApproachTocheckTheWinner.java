//package org.ticTacToe.service;
//
//import org.ticTacToe.models.Cell;
//
//public class BruteForceApproachTocheckTheWinner {
//    public static String checkIfAnyPlayerWinNoobMethod(Cell[][] cells, int boardSize) {
////        for(int i = 0; i< cells.length; i++){
////            HashMap<String, Integer> horizontal = new HashMap<>();
////            for(int j = 0; j< cells[i].length ; j++){
////                if(cells[i][j] != null && cells[i][j].getMove() != null){
////                    String key = cells[i][j].getMove().getPlayerId();
////                    if(!horizontal.containsKey(key)){
////                        horizontal.put(key, 1);
////                    }else{
////                        horizontal.put(key, horizontal.get(key)+1);
////                    }
////                }
////            }
////
////            for(Map.Entry<String, Integer> isWinner : horizontal.entrySet()){
////                if(isWinner.getValue().equals(boardSize)){
////
////
////                    return isWinner.getKey();
////                }
////            }
////        }
//////-------------------------------------------------------------------------------
////        for(int i = 0; i< cells.length; i++){
////            HashMap<String, Integer> vertical = new HashMap<>();
////            for(int j = 0; j< cells[i].length ; j++){
////                if(cells[j][i] != null && cells[j][i].getMove() != null){
////                    String key = cells[j][i].getMove().getPlayerId();
////                    if(!vertical.containsKey(key)){
////                        vertical.put(key, 1);
////                    }else{
////                        vertical.put(key, vertical.get(key)+1);
////                    }
////                }
////
////
////            }
////            for(Map.Entry<String, Integer> isWinner : vertical.entrySet()){
////                if(isWinner.getValue().equals(boardSize)){
////                    return isWinner.getKey();
////                }
////            }
////        }
//////----------------------------------------------------------------------------------
////        HashMap<String, Integer> leftDiagonal = new HashMap<>();
////        for(int i = 0; i< cells.length; i++){
////            for(int j = 0; j< cells[i].length ; j++){
////                if(i==j){
////                    if(cells[j][i] != null && cells[j][i].getMove() != null){
////                        String key = cells[j][i].getMove().getPlayerId();
////                        if(!leftDiagonal.containsKey(key)){
////                            leftDiagonal.put(key, 1);
////                        }else{
////                            leftDiagonal.put(key, leftDiagonal.get(key)+1);
////                        }
////                    }
////                }
////            }
////        }
////
////        for(Map.Entry<String, Integer> isWinner : leftDiagonal.entrySet()){
////            if(isWinner.getValue().equals(boardSize)){
////                return isWinner.getKey();
////            }
////        }
////
////        //----------------------------------------------------------------------------------
////        HashMap<String, Integer> rightDiagonal = new HashMap<>();
////        for(int i = 0; i< cells.length; i++){
////            for(int j = 0; j< cells[i].length ; j++){
////                if(i+j == boardSize-1){
////                    if(cells[j][i] != null && cells[j][i].getMove() != null){
////                        String key = cells[j][i].getMove().getPlayerId();
////                        if(!rightDiagonal.containsKey(key)){
////                            rightDiagonal.put(key, 1);
////                        }else{
////                            rightDiagonal.put(key, leftDiagonal.get(key)+1);
////                        }
////                    }
////                }
////            }
////        }
////
////        for(Map.Entry<String, Integer> isWinner : rightDiagonal.entrySet()){
////            if(isWinner.getValue().equals(boardSize)){
////                return isWinner.getKey();
////            }
////        }
//
//        return "-1";
//
//    }
//}
