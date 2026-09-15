package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityMetalGrade;
import fpml.consolidated.com.validation.CommodityMetalGradeTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityMetalGradeValidator;
import fpml.consolidated.com.validation.exists.CommodityMetalGradeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityMetalGrade.class)
public class CommodityMetalGradeMeta implements RosettaMetaData<CommodityMetalGrade> {

	@Override
	public List<Validator<? super CommodityMetalGrade>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityMetalGrade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityMetalGrade> validator(ValidatorFactory factory) {
		return factory.<CommodityMetalGrade>create(CommodityMetalGradeValidator.class);
	}

	@Override
	public Validator<? super CommodityMetalGrade> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityMetalGrade>create(CommodityMetalGradeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityMetalGrade> validator() {
		return new CommodityMetalGradeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityMetalGrade> typeFormatValidator() {
		return new CommodityMetalGradeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMetalGrade, Set<String>> onlyExistsValidator() {
		return new CommodityMetalGradeOnlyExistsValidator();
	}
}
