package drr.base.margin.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.margin.CollateralReportInstructionBase;
import drr.base.margin.validation.CollateralReportInstructionBaseTypeFormatValidator;
import drr.base.margin.validation.CollateralReportInstructionBaseValidator;
import drr.base.margin.validation.exists.CollateralReportInstructionBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CollateralReportInstructionBase.class)
public class CollateralReportInstructionBaseMeta implements RosettaMetaData<CollateralReportInstructionBase> {

	@Override
	public List<Validator<? super CollateralReportInstructionBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralReportInstructionBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralReportInstructionBase> validator(ValidatorFactory factory) {
		return factory.<CollateralReportInstructionBase>create(CollateralReportInstructionBaseValidator.class);
	}

	@Override
	public Validator<? super CollateralReportInstructionBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralReportInstructionBase>create(CollateralReportInstructionBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralReportInstructionBase> validator() {
		return new CollateralReportInstructionBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralReportInstructionBase> typeFormatValidator() {
		return new CollateralReportInstructionBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralReportInstructionBase, Set<String>> onlyExistsValidator() {
		return new CollateralReportInstructionBaseOnlyExistsValidator();
	}
}
