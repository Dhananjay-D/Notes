"""
Created on Sat Jun 22 22:05:46 2024

@author: ARHAM MULLA
"""
#tw4
import math
def minimax(currDepth,NodeIndex,maxTurn,scores,targetDepth):
    if currDepth==targetDepth:
        return scores[NodeIndex]
    if maxTurn:
        LEFT=minimax(currDepth+1, NodeIndex*2, False, scores, targetDepth)
        RIGHT=minimax(currDepth+1, NodeIndex*2+1, False, scores, targetDepth)
        print("Node at depth ",currDepth,"with value: ",max(LEFT,RIGHT))
        return max(LEFT,RIGHT)
    else:
        LEFT=minimax(currDepth+1, NodeIndex*2, True, scores, targetDepth)
        RIGHT=minimax(currDepth+1, NodeIndex*2+1, True, scores, targetDepth)
        print("Node at depth ",currDepth,"with value: ",min(LEFT,RIGHT))
        return min(LEFT,RIGHT)

scores=[-1,2,3,4,5,6,7,-8]
targetDepth=math.floor(math.log(len(scores),2)) 
print("The optimal solution is ", minimax (0,0, True, scores,targetDepth))