package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationEMIR_2015;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryClassificationEMIR_2015TypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryClassificationEMIR_2015Validator;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegulatoryClassificationEMIR_2015OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryClassificationEMIR_2015.class)
public class RegulatoryClassificationEMIR_2015Meta implements RosettaMetaData<RegulatoryClassificationEMIR_2015> {

	@Override
	public List<Validator<? super RegulatoryClassificationEMIR_2015>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatoryClassificationEMIR_2015, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryClassificationEMIR_2015> validator(ValidatorFactory factory) {
		return factory.<RegulatoryClassificationEMIR_2015>create(RegulatoryClassificationEMIR_2015Validator.class);
	}

	@Override
	public Validator<? super RegulatoryClassificationEMIR_2015> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryClassificationEMIR_2015>create(RegulatoryClassificationEMIR_2015TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryClassificationEMIR_2015> validator() {
		return new RegulatoryClassificationEMIR_2015Validator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryClassificationEMIR_2015> typeFormatValidator() {
		return new RegulatoryClassificationEMIR_2015TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryClassificationEMIR_2015, Set<String>> onlyExistsValidator() {
		return new RegulatoryClassificationEMIR_2015OnlyExistsValidator();
	}
}
