package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityProductGrade;
import fpml.consolidated.com.validation.CommodityProductGradeTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityProductGradeValidator;
import fpml.consolidated.com.validation.exists.CommodityProductGradeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityProductGrade.class)
public class CommodityProductGradeMeta implements RosettaMetaData<CommodityProductGrade> {

	@Override
	public List<Validator<? super CommodityProductGrade>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityProductGrade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityProductGrade> validator(ValidatorFactory factory) {
		return factory.<CommodityProductGrade>create(CommodityProductGradeValidator.class);
	}

	@Override
	public Validator<? super CommodityProductGrade> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityProductGrade>create(CommodityProductGradeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityProductGrade> validator() {
		return new CommodityProductGradeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityProductGrade> typeFormatValidator() {
		return new CommodityProductGradeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityProductGrade, Set<String>> onlyExistsValidator() {
		return new CommodityProductGradeOnlyExistsValidator();
	}
}
