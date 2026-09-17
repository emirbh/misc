package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.MTARatingsBased;
import cdm.legaldocumentation.csa.validation.MTARatingsBasedTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.MTARatingsBasedValidator;
import cdm.legaldocumentation.csa.validation.exists.MTARatingsBasedOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=MTARatingsBased.class)
public class MTARatingsBasedMeta implements RosettaMetaData<MTARatingsBased> {

	@Override
	public List<Validator<? super MTARatingsBased>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MTARatingsBased, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MTARatingsBased> validator(ValidatorFactory factory) {
		return factory.<MTARatingsBased>create(MTARatingsBasedValidator.class);
	}

	@Override
	public Validator<? super MTARatingsBased> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MTARatingsBased>create(MTARatingsBasedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MTARatingsBased> validator() {
		return new MTARatingsBasedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MTARatingsBased> typeFormatValidator() {
		return new MTARatingsBasedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MTARatingsBased, Set<String>> onlyExistsValidator() {
		return new MTARatingsBasedOnlyExistsValidator();
	}
}
