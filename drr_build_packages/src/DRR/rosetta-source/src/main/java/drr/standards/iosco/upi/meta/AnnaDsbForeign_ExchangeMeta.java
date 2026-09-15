package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbForeign_Exchange;
import drr.standards.iosco.upi.validation.AnnaDsbForeign_ExchangeTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbForeign_ExchangeValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbForeign_ExchangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbForeign_Exchange.class)
public class AnnaDsbForeign_ExchangeMeta implements RosettaMetaData<AnnaDsbForeign_Exchange> {

	@Override
	public List<Validator<? super AnnaDsbForeign_Exchange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbForeign_Exchange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbForeign_Exchange> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbForeign_Exchange>create(AnnaDsbForeign_ExchangeValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbForeign_Exchange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbForeign_Exchange>create(AnnaDsbForeign_ExchangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbForeign_Exchange> validator() {
		return new AnnaDsbForeign_ExchangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbForeign_Exchange> typeFormatValidator() {
		return new AnnaDsbForeign_ExchangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbForeign_Exchange, Set<String>> onlyExistsValidator() {
		return new AnnaDsbForeign_ExchangeOnlyExistsValidator();
	}
}
