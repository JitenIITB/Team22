   M S B A M L   `   `   `  ����|  xSystem.Windows.Controls.DataVisualization.Toolkit, Version=3.5.40128.1, Culture=neutral, PublicKeyToken=31bf3856ad364e35�{clr-namespace:System.Windows.Controls.DataVisualization.Charting;assembly=System.Windows.Controls.DataVisualization.Toolkit2System.Windows.Controls.DataVisualization.Charting  5   	   P LMiniBloomDataAnalysis, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null=#clr-namespace:MiniBloomDataAnalysisMiniBloomDataAnalysis 5   	   #   MiniBloomDataAnalysis.Window1   5   	   W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   �chartingToolkit{clr-namespace:System.Windows.Controls.DataVisualization.Charting;assembly=System.Windows.Controls.DataVisualization.Toolkit     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   5local#clr-namespace:MiniBloomDataAnalysis     5   	     � Title$  Window1��5	   	   $��447.594��6   $��763.636��6*   
�������.��5
      � .+�5   
   �� -   5         ��Name$ label��5      $��Label��6   $
��Left=�6/   $��28��6J   $��
10,182,0,0q�6V   $	��Top=�6j   $	��122��6�   �� 5   
   -   5        $ 
label_Copy��5      $��Label��6$   $
��Left=�64   $��37��6O   $��
10,200,0,0q�6[   $	��Top=�6o   $	��122��6�    J� RenderTransformOrigin$ 0.503,0.658&�6�   �� 5   
   -   5        $ label_Copy1��5      $��Label��6%   $
��Left=�65   $��45��6P   $��
10,242,0,0q�6\   $	��Top=�6p   $	��149��6�   �� 5   
   -   5        $ label_Copy2��5      $��Label��6%   $
��Left=�65   $��46��6P   $��
10,292,0,0q�6\   $	��Top=�6p   $	��165��6�   �� 5   
   -   5        $ label_Copy3��5      $��Label��6%   $
��Left=�65   $��47��6P   $��
10,343,0,0q�6\   $	��Top=�6p   $	��165��6�   �� 5   
   -   5        $ lblUserName��5      $�� ��6%   $
��Left=�60   $��27��6K   $��	591,0,0,0q�6W   $	��Top=�6j   $��86��6�   $��Italic$�6�   �� 5   
   -   5         ��Name$ 	txtSearch��5      $
��Left=�6&   $��31��6A   $��	10,92,0,0q�6M    �� TextWrapping$
 Wrap=�6`   $�� ��6t   $��Center=�6|   $��Center=�6�   $	��Top=�6�   $	��117��6�   ���	#FFBBB6B66�   �� 5   
   -   5         ��Name$ 	btnSearch��5      $��Search��6$   $
��Left=�65   $��31��6P   $��
132,92,0,0q�6\   $	��Top=�6p   $��43��6�   6�   �� 5   
   -	   5         ��Name$ 	lstSearch��5      $
��Left=�6%   $��54��6@   $��
10,123,0,0q�6L   $	��Top=�6`   $	��117��6x   
����������	#FFD4D2D26�   �� 5   
   -
   5        $ 
lblSignout��5      $��SignOut��6$   $��Center=�66   $
��Left=�6Z   $��41��6u   $��	682,0,0,0q�6�   $	��Top=�6�   $��64��6�   $��Italic$�6�   6�   �� 5   
   -   5        $ label1��5      $��Market Data Analysis��6    $��Center=�6?   $��Center=�6c   $
��Left=�6�   $��60��6�   $��	65,32,0,0q�6�   $	��Top=�6�   $	��571��6�   $��26.667(�6�   >   8System.Windows.Controls.DataVisualization.Charting.Chart  5   
   -   5        $��	lineChart��5          Title$ Stock prices��5   (   $	��400��6=   $	��300��6I   $��180,92,176,26q�6V   ��6m   Z�    Series. 5      C   =System.Windows.Controls.DataVisualization.Charting.LineSeries  -   5        $��	lnsStock1��5   )   ?   9System.Windows.Controls.DataVisualization.Charting.Series	   Title$	 Stock plotter��5      H   BSystem.Windows.Controls.DataVisualization.Charting.DataPointSeries
   DependentValuePath$
 Value��6)      IndependentValuePath$	 Key��5         IsSelectionEnabled .    ItemsSource 5      ��  � DataContext 6+   �� 5   )     5      -   5        $��lnstock2��5   )   $	 Second stocks��5   1   $
 Value��5   1   $	 Key��5    1    .  5!   1   �� *[1]+ 5"   )   �� *[1]+5#   )   5%      �� 5&   
   -   5        $ btnpopulate��5&      $��Populate��6&   $
��Left=�69   $��58��6T   $��591,123,0,0q�6`   $	��Top=�6u   $	��155��6�   $ 
0.04,0.897&�6�   6�   ��5'   
   �� 5(       �� ImageSource$. (C:\Users\Grad20\Desktop/stock-market.jpg��6    �� Opacity$	 0.1Q�6P   5+      5,      