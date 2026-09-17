package cdm.observable.asset.meta;

import cdm.observable.asset.CreditNotations;
import cdm.observable.asset.validation.CreditNotationsTypeFormatValidator;
import cdm.observable.asset.validation.CreditNotationsValidator;
import cdm.observable.asset.validation.datarule.CreditNotationsOneOf0;
import cdm.observable.asset.validation.exists.CreditNotationsOnlyExistsValidator;
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
@RosettaMeta(model=CreditNotations.class)
public class CreditNotationsMeta implements RosettaMetaData<CreditNotations> {

	@Override
	public List<Validator<? super CreditNotations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CreditNotations>create(CreditNotationsOneOf0.class)
		);
	}
	
	@Override
	public List<Function<? super CreditNotations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditNotations> validator(ValidatorFactory factory) {
		return factory.<CreditNotations>create(CreditNotationsValidator.class);
	}

	@Override
	public Validator<? super CreditNotations> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditNotations>create(CreditNotationsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditNotations> validator() {
		return new CreditNotationsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditNotations> typeFormatValidator() {
		return new CreditNotationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditNotations, Set<String>> onlyExistsValidator() {
		return new CreditNotationsOnlyExistsValidator();
	}
}
