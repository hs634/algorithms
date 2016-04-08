__author__ = 'hs634'

index = (i * height * depth) + (j * depth) + k

for ( int i = 0; i < width; ++i )
	for ( int j = 0; j < height; ++j )
		for ( int k = 0; k < depth; ++k )
			sum += data[ (long)i*(long)height*(long)depth + (long)j*(long)depth + (long)k ];

index = (i * height + j) * depth + k

for ( int i = 0; i < width; ++i )
	for ( int j = 0; j < height; ++j )
		for ( int k = 0; k < depth; ++k )
			sum += data[ ((long)i*(long)height + (long)j)*(long)depth + (long)k ];


