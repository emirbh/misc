package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.Counterparty46__3;
import iso20022.auth030.asic.validation.Counterparty46__3TypeFormatValidator;
import iso20022.auth030.asic.validation.Counterparty46__3Validator;
import iso20022.auth030.asic.validation.exists.Counterparty46__3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Counterparty46__3.class)
public class Counterparty46__3Meta implements RosettaMetaData<Counterparty46__3> {

	@Override
	public List<Validator<? super Counterparty46__3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Counterparty46__3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Counterparty46__3> validator(ValidatorFactory factory) {
		return factory.<Counterparty46__3>create(Counterparty46__3Validator.class);
	}

	@Override
	public Validator<? super Counterparty46__3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Counterparty46__3>create(Counterparty46__3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Counterparty46__3> validator() {
		return new Counterparty46__3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super Counterparty46__3> typeFormatValidator() {
		return new Counterparty46__3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Counterparty46__3, Set<String>> onlyExistsValidator() {
		return new Counterparty46__3OnlyExistsValidator();
	}
}
