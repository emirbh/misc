package drr.regulation.common.dtcc.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.dtcc.trade.ProductGradeReport;
import drr.regulation.common.dtcc.trade.validation.ProductGradeReportTypeFormatValidator;
import drr.regulation.common.dtcc.trade.validation.ProductGradeReportValidator;
import drr.regulation.common.dtcc.trade.validation.exists.ProductGradeReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ProductGradeReport.class)
public class ProductGradeReportMeta implements RosettaMetaData<ProductGradeReport> {

	@Override
	public List<Validator<? super ProductGradeReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProductGradeReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ProductGradeReport> validator(ValidatorFactory factory) {
		return factory.<ProductGradeReport>create(ProductGradeReportValidator.class);
	}

	@Override
	public Validator<? super ProductGradeReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ProductGradeReport>create(ProductGradeReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ProductGradeReport> validator() {
		return new ProductGradeReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ProductGradeReport> typeFormatValidator() {
		return new ProductGradeReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProductGradeReport, Set<String>> onlyExistsValidator() {
		return new ProductGradeReportOnlyExistsValidator();
	}
}
