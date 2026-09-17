package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.SettlementPriceSource;
import fpml.consolidated.shared.validation.SettlementPriceSourceTypeFormatValidator;
import fpml.consolidated.shared.validation.SettlementPriceSourceValidator;
import fpml.consolidated.shared.validation.exists.SettlementPriceSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementPriceSource.class)
public class SettlementPriceSourceMeta implements RosettaMetaData<SettlementPriceSource> {

	@Override
	public List<Validator<? super SettlementPriceSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementPriceSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementPriceSource> validator(ValidatorFactory factory) {
		return factory.<SettlementPriceSource>create(SettlementPriceSourceValidator.class);
	}

	@Override
	public Validator<? super SettlementPriceSource> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementPriceSource>create(SettlementPriceSourceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPriceSource> validator() {
		return new SettlementPriceSourceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPriceSource> typeFormatValidator() {
		return new SettlementPriceSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPriceSource, Set<String>> onlyExistsValidator() {
		return new SettlementPriceSourceOnlyExistsValidator();
	}
}
