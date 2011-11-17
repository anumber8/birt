
package org.eclipse.birt.data.engine.olap.data.impl.aggregation.function;

import java.io.IOException;
import java.util.List;

import org.eclipse.birt.data.engine.olap.data.impl.aggregation.function.MonthToDateFunction;
import org.eclipse.birt.data.engine.olap.data.impl.aggregation.function.TimeMember;

import testutil.BaseTestCase;

/**
 * this class test month to date funciton, you can refer to MonthToDateFunction
 * for details
 * 
 * @author peng.shi
 * 
 */
public class MonthToDateTest extends BaseTestCase
{

	public void testMTD1( ) throws IOException
	{
		int[] values = new int[]{
				2002, 3, 21
		};
		String[] types = new String[]{
				TimeMember.TIME_LEVEL_TYPE_YEAR,
				TimeMember.TIME_LEVEL_TYPE_MONTH,
				TimeMember.TIME_LEVEL_TYPE_DAY_OF_MONTH
		};
		TimeMember timeMember = new TimeMember( values, types );
		List<TimeMember> timeMembers = new MonthToDateFunction( ).getResult( timeMember );
		printMembers( timeMembers );
		checkOutputFile( );
	}

	public void testMTD2( ) throws IOException
	{
		int[] values = new int[]{
				2002, 1, 3, 21
		};
		String[] types = new String[]{
				TimeMember.TIME_LEVEL_TYPE_YEAR,
				TimeMember.TIME_LEVEL_TYPE_QUARTER,
				TimeMember.TIME_LEVEL_TYPE_MONTH,
				TimeMember.TIME_LEVEL_TYPE_DAY_OF_MONTH
		};
		TimeMember timeMember = new TimeMember( values, types );
		List<TimeMember> timeMembers = new MonthToDateFunction( ).getResult( timeMember );
		printMembers( timeMembers );
		checkOutputFile( );
	}

	public void testMTD3( ) throws IOException
	{
		int[] values = new int[]{
				2011, 3, 9, 4
		};
		String[] types = new String[]{
				TimeMember.TIME_LEVEL_TYPE_YEAR,
				TimeMember.TIME_LEVEL_TYPE_QUARTER,
				TimeMember.TIME_LEVEL_TYPE_MONTH,
				TimeMember.TIME_LEVEL_TYPE_WEEK_OF_MONTH
		};
		TimeMember timeMember = new TimeMember( values, types );
		List<TimeMember> timeMembers = new MonthToDateFunction( ).getResult( timeMember );
		printMembers( timeMembers );
		checkOutputFile( );

	}

	public void testMTD4( ) throws IOException
	{
		int[] values = new int[]{
				2002, 1, 2, 4
		};
		String[] types = new String[]{
				TimeMember.TIME_LEVEL_TYPE_YEAR,
				TimeMember.TIME_LEVEL_TYPE_QUARTER,
				TimeMember.TIME_LEVEL_TYPE_MONTH,
				TimeMember.TIME_LEVEL_TYPE_WEEK_OF_MONTH
		};
		TimeMember timeMember = new TimeMember( values, types );
		List<TimeMember> timeMembers = new MonthToDateFunction( ).getResult( timeMember );
		printMembers( timeMembers );
		checkOutputFile( );

	}

	public void testMTD5( ) throws IOException
	{
		int[] values = new int[]{
				2002, 100
		};
		String[] types = new String[]{
				TimeMember.TIME_LEVEL_TYPE_YEAR,
				TimeMember.TIME_LEVEL_TYPE_DAY_OF_YEAR
		};
		TimeMember timeMember = new TimeMember( values, types );
		List<TimeMember> timeMembers = new MonthToDateFunction( ).getResult( timeMember );
		printMembers( timeMembers );
		checkOutputFile( );
	}

	public void testMTD6( ) throws IOException
	{
		int[] values = new int[]{
				2011, 3, 9, 4, 39, 5, 22, 265
		};
		String[] types = new String[]{
				TimeMember.TIME_LEVEL_TYPE_YEAR,
				TimeMember.TIME_LEVEL_TYPE_QUARTER,
				TimeMember.TIME_LEVEL_TYPE_MONTH,
				TimeMember.TIME_LEVEL_TYPE_WEEK_OF_MONTH,
				TimeMember.TIME_LEVEL_TYPE_WEEK_OF_YEAR,
				TimeMember.TIME_LEVEL_TYPE_DAY_OF_WEEK,
				TimeMember.TIME_LEVEL_TYPE_DAY_OF_MONTH,
				TimeMember.TIME_LEVEL_TYPE_DAY_OF_YEAR
		};
		TimeMember timeMember = new TimeMember( values, types );
		List<TimeMember> timeMembers = new MonthToDateFunction( ).getResult( timeMember );
		printMembers( timeMembers );
		checkOutputFile( );
	}

	public void testMTD7( ) throws IOException
	{
		int[] values = new int[]{
				2011, 3, 8
		};
		String[] types = new String[]{
				TimeMember.TIME_LEVEL_TYPE_YEAR,
				TimeMember.TIME_LEVEL_TYPE_QUARTER,
				TimeMember.TIME_LEVEL_TYPE_MONTH
		};
		TimeMember timeMember = new TimeMember( values, types );
		List<TimeMember> timeMembers = new MonthToDateFunction( ).getResult( timeMember );
		printMembers( timeMembers );
		checkOutputFile( );
	}
	
	public void testMTD8( ) throws IOException
	{
		int[] values = new int[]{
				2011, 3, 9, 6
		};
		String[] types = new String[]{
				TimeMember.TIME_LEVEL_TYPE_YEAR,
				TimeMember.TIME_LEVEL_TYPE_QUARTER,
				TimeMember.TIME_LEVEL_TYPE_MONTH,
				TimeMember.TIME_LEVEL_TYPE_DAY_OF_MONTH
		};
		TimeMember timeMember = new TimeMember( values, types );
		MonthToDateFunction func = new MonthToDateFunction( );
		func.setIsCurrent( true );
		List<TimeMember> timeMembers = func.getResult( timeMember );
		printMembers( timeMembers );
		checkOutputFile( );
	}
	
	public void testMTD9( ) throws IOException
	{
		int[] values = new int[]{
				2011, 4, 10, 2
		};
		String[] types = new String[]{
				TimeMember.TIME_LEVEL_TYPE_YEAR,
				TimeMember.TIME_LEVEL_TYPE_QUARTER,
				TimeMember.TIME_LEVEL_TYPE_MONTH,
				TimeMember.TIME_LEVEL_TYPE_WEEK_OF_MONTH
		};
		TimeMember timeMember = new TimeMember( values, types );
		MonthToDateFunction func = new MonthToDateFunction( );
		func.setIsCurrent( true );
		List<TimeMember> timeMembers = func.getResult( timeMember );
		printMembers( timeMembers );
		checkOutputFile( );
	}

	private void printMembers( List<TimeMember> timeMembers )
	{
		String[] levelTypes;
		int[] memberValues;
		for ( TimeMember timeMember : timeMembers )
		{
			levelTypes = timeMember.getLevelType( );
			memberValues = timeMember.getMemberValue( );
			for ( int i = 0; i < levelTypes.length; i++ )
			{
				testPrint( levelTypes[i] + " " );
			}
			testPrintln( "" );
			for ( int i = 0; i < memberValues.length; i++ )
			{
				testPrint( memberValues[i] + " " );
			}
			testPrintln( "" );
		}
	}
}
