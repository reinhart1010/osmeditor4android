# Object search

Vespucci supports a large subset of JOSM search expressions, these can be used for locating and selecting specific objects in the in memory data, and for matching elements against roles in preset member_expression attributes.

As there is essentially no documentation available from JOSM there is no guarantee that the behaviour is the same in all cases, known and deliberate differences are noted below. A reformatted and expanded version of what is available from JOSM is available here [JOSM filter documentation](https://github.com/simonpoole/JosmFilterDoc/blob/master/filter.md).


## Supported expressions

|    |Syntax                            | Vespucci specific notes |
|--- |--- |---|
|✅| Baker Street                         | | 
|✅| __"Baker Street"__                   | |
|✅| _key_**:**_valuefragment_            | |
|✅| **-**_key_**:**_valuefragment_       | |
|✅| _key_                                | |
|✅| _key_**=**_value_                    | |
|✅| *key*__=*__                          | |
|✅| _key_**=**                           | |
|✅| __*=__*value*                        | |
|✅| _key_**>**_reference_                | Compares the value associated with key to reference, if possible if will convert to numeric values first |
|✅| _key_**<**_reference_                | dito |
|✅|_expr_ _expr_                        | |
|✅|_expr_ __&#124;__ _expr_             | |   
|✅|_expr_ __OR__ _expr_                 | |  
|✅|__-__*expr*                          | | 
|✅|__(__*expr*__)__                     | | 
|✅|__type:node__                        | | 
|✅|__type:way__                         | | 
|✅|__type:relation__                    | | 
|✅|__closed__                           | | 
|✅|__untagged__                         | |
|✅|__preset:"__preset item path__"__    | Vespucci uses "&#124;" as preset path segment separator and only fixed tags are considered for matching |
|✅|__preset:"__preset group path/\*__"__ | The asterix is ignored, the relevant criteria is if the path references a preset group | 
| | __user:__                          | |
|✅|__id:__                              | | 
|✅|__version:__                         | |
| |__changeset:__                      | |
|✅|__timestamp:__                       |  |
|✅|__nodes:__*range*                    | All nodes are counted, for closed ways that implies that start and end node are counted separately | 
|✅|__ways:__*range*                     | |
|✅|__tags:__*range*                     | | 
|✅|__role:__*role*                      | |
|✅|__areasize:__*range*                 | | 
|✅|__waylength:__*range*                | | 
|✅|__modified__                         | | 
|✅|__new__                              | | 
✅|__selected__                         | |
✅|__incomplete__                       | Only used for relations  |
|✅|__deleted__                          | | 
||__child__ _expr_                     | | 
||__parent__ _expr_                    | | 
|✅|__hasRole:__*role*                   | | 
||__nth:__*number*                     | | 
||__nth%:__*number*                    | |
|✅|__inview__                           | | 
|✅|__allinview__                        | | 
|✅|__indownloadedarea__                 | | 
|✅|__allindownloadedarea__              | | 
