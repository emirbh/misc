package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.business.events.validation.TradePackageTypeFormatValidator;
import fpml.consolidated.business.events.validation.TradePackageValidator;
import fpml.consolidated.business.events.validation.datarule.TradePackageChoice;
import fpml.consolidated.business.events.validation.exists.TradePackageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradePackage.class)
public class TradePackageMeta implements RosettaMetaData<TradePackage> {

	@Override
	public List<Validator<? super TradePackage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradePackage>create(TradePackageChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradePackage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradePackage> validator(ValidatorFactory factory) {
		return factory.<TradePackage>create(TradePackageValidator.class);
	}

	@Override
	public Validator<? super TradePackage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradePackage>create(TradePackageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradePackage> validator() {
		return new TradePackageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradePackage> typeFormatValidator() {
		return new TradePackageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradePackage, Set<String>> onlyExistsValidator() {
		return new TradePackageOnlyExistsValidator();
	}
}
