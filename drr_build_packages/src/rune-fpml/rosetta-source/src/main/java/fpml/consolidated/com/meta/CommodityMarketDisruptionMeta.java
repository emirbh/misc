package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityMarketDisruption;
import fpml.consolidated.com.validation.CommodityMarketDisruptionTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityMarketDisruptionValidator;
import fpml.consolidated.com.validation.datarule.CommodityMarketDisruptionChoice0;
import fpml.consolidated.com.validation.datarule.CommodityMarketDisruptionChoice1;
import fpml.consolidated.com.validation.exists.CommodityMarketDisruptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityMarketDisruption.class)
public class CommodityMarketDisruptionMeta implements RosettaMetaData<CommodityMarketDisruption> {

	@Override
	public List<Validator<? super CommodityMarketDisruption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityMarketDisruption>create(CommodityMarketDisruptionChoice0.class),
			factory.<CommodityMarketDisruption>create(CommodityMarketDisruptionChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityMarketDisruption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityMarketDisruption> validator(ValidatorFactory factory) {
		return factory.<CommodityMarketDisruption>create(CommodityMarketDisruptionValidator.class);
	}

	@Override
	public Validator<? super CommodityMarketDisruption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityMarketDisruption>create(CommodityMarketDisruptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityMarketDisruption> validator() {
		return new CommodityMarketDisruptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityMarketDisruption> typeFormatValidator() {
		return new CommodityMarketDisruptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMarketDisruption, Set<String>> onlyExistsValidator() {
		return new CommodityMarketDisruptionOnlyExistsValidator();
	}
}
