package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.RegulatoryDisclosure;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryDisclosureTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.RegulatoryDisclosureValidator;
import fpml.consolidated.recordkeeping.processes.validation.datarule.RegulatoryDisclosureChoice;
import fpml.consolidated.recordkeeping.processes.validation.exists.RegulatoryDisclosureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatoryDisclosure.class)
public class RegulatoryDisclosureMeta implements RosettaMetaData<RegulatoryDisclosure> {

	@Override
	public List<Validator<? super RegulatoryDisclosure>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RegulatoryDisclosure>create(RegulatoryDisclosureChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RegulatoryDisclosure, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatoryDisclosure> validator(ValidatorFactory factory) {
		return factory.<RegulatoryDisclosure>create(RegulatoryDisclosureValidator.class);
	}

	@Override
	public Validator<? super RegulatoryDisclosure> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatoryDisclosure>create(RegulatoryDisclosureTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryDisclosure> validator() {
		return new RegulatoryDisclosureValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatoryDisclosure> typeFormatValidator() {
		return new RegulatoryDisclosureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatoryDisclosure, Set<String>> onlyExistsValidator() {
		return new RegulatoryDisclosureOnlyExistsValidator();
	}
}
