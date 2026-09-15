package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.RegulatorId;
import fpml.consolidated.doc.validation.RegulatorIdTypeFormatValidator;
import fpml.consolidated.doc.validation.RegulatorIdValidator;
import fpml.consolidated.doc.validation.exists.RegulatorIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RegulatorId.class)
public class RegulatorIdMeta implements RosettaMetaData<RegulatorId> {

	@Override
	public List<Validator<? super RegulatorId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegulatorId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegulatorId> validator(ValidatorFactory factory) {
		return factory.<RegulatorId>create(RegulatorIdValidator.class);
	}

	@Override
	public Validator<? super RegulatorId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegulatorId>create(RegulatorIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegulatorId> validator() {
		return new RegulatorIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegulatorId> typeFormatValidator() {
		return new RegulatorIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegulatorId, Set<String>> onlyExistsValidator() {
		return new RegulatorIdOnlyExistsValidator();
	}
}
