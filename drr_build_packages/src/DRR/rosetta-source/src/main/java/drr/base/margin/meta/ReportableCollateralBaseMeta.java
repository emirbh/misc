package drr.base.margin.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.margin.ReportableCollateralBase;
import drr.base.margin.validation.ReportableCollateralBaseTypeFormatValidator;
import drr.base.margin.validation.ReportableCollateralBaseValidator;
import drr.base.margin.validation.exists.ReportableCollateralBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ReportableCollateralBase.class)
public class ReportableCollateralBaseMeta implements RosettaMetaData<ReportableCollateralBase> {

	@Override
	public List<Validator<? super ReportableCollateralBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportableCollateralBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportableCollateralBase> validator(ValidatorFactory factory) {
		return factory.<ReportableCollateralBase>create(ReportableCollateralBaseValidator.class);
	}

	@Override
	public Validator<? super ReportableCollateralBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportableCollateralBase>create(ReportableCollateralBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportableCollateralBase> validator() {
		return new ReportableCollateralBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportableCollateralBase> typeFormatValidator() {
		return new ReportableCollateralBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportableCollateralBase, Set<String>> onlyExistsValidator() {
		return new ReportableCollateralBaseOnlyExistsValidator();
	}
}
