package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.validation.CollateralReportInstructionTypeFormatValidator;
import drr.regulation.common.validation.CollateralReportInstructionValidator;
import drr.regulation.common.validation.exists.CollateralReportInstructionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CollateralReportInstruction.class)
public class CollateralReportInstructionMeta implements RosettaMetaData<CollateralReportInstruction> {

	@Override
	public List<Validator<? super CollateralReportInstruction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralReportInstruction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralReportInstruction> validator(ValidatorFactory factory) {
		return factory.<CollateralReportInstruction>create(CollateralReportInstructionValidator.class);
	}

	@Override
	public Validator<? super CollateralReportInstruction> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralReportInstruction>create(CollateralReportInstructionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralReportInstruction> validator() {
		return new CollateralReportInstructionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralReportInstruction> typeFormatValidator() {
		return new CollateralReportInstructionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralReportInstruction, Set<String>> onlyExistsValidator() {
		return new CollateralReportInstructionOnlyExistsValidator();
	}
}
