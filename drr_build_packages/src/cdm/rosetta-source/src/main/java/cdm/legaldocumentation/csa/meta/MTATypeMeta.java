package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.MTAType;
import cdm.legaldocumentation.csa.validation.MTATypeTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.MTATypeValidator;
import cdm.legaldocumentation.csa.validation.exists.MTATypeOnlyExistsValidator;
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
@RosettaMeta(model=MTAType.class)
public class MTATypeMeta implements RosettaMetaData<MTAType> {

	@Override
	public List<Validator<? super MTAType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MTAType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MTAType> validator(ValidatorFactory factory) {
		return factory.<MTAType>create(MTATypeValidator.class);
	}

	@Override
	public Validator<? super MTAType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MTAType>create(MTATypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MTAType> validator() {
		return new MTATypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MTAType> typeFormatValidator() {
		return new MTATypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MTAType, Set<String>> onlyExistsValidator() {
		return new MTATypeOnlyExistsValidator();
	}
}
