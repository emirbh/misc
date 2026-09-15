package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.TaxonomyClassification;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.standards.iosco.upi.AnnaDsbAGRI;
import drr.standards.iosco.upi.AnnaDsbAdditionalSubProduct;
import drr.standards.iosco.upi.AnnaDsbAdditionalSubProductEnum;
import drr.standards.iosco.upi.AnnaDsbBaseProduct;
import drr.standards.iosco.upi.AnnaDsbENVR;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbFRGT;
import drr.standards.iosco.upi.AnnaDsbFRTL;
import drr.standards.iosco.upi.AnnaDsbINDP;
import drr.standards.iosco.upi.AnnaDsbMETL;
import drr.standards.iosco.upi.AnnaDsbNRGY;
import drr.standards.iosco.upi.AnnaDsbOTHC;
import drr.standards.iosco.upi.AnnaDsbPAPR;
import drr.standards.iosco.upi.AnnaDsbPOLY;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_AnnaDsbUpiRequestBaseProductForCommodity.Create_AnnaDsbUpiRequestBaseProductForCommodityDefault.class)
public abstract class Create_AnnaDsbUpiRequestBaseProductForCommodity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_AnnaDsbEmpty create_AnnaDsbEmpty;
	@Inject protected GetClassificationValueByOrdinal getClassificationValueByOrdinal;

	/**
	* @param product 
	* @return out 
	*/
	public AnnaDsbBaseProduct evaluate(NonTransferableProduct product) {
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder outBuilder = doEvaluate(product);
		
		final AnnaDsbBaseProduct out;
		if (outBuilder == null) {
			out = null;
		} else {
			out = outBuilder.build();
			objectValidator.validate(AnnaDsbBaseProduct.class, out);
		}
		
		return out;
	}

	protected abstract AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder doEvaluate(NonTransferableProduct product);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product);

	protected abstract MapperS<? extends TaxonomyValue> esmaTaxonomy(NonTransferableProduct product);

	protected abstract MapperS<String> baseProduct(NonTransferableProduct product);

	protected abstract MapperS<String> subProduct(NonTransferableProduct product);

	protected abstract MapperS<String> additionalSubProduct(NonTransferableProduct product);

	public static class Create_AnnaDsbUpiRequestBaseProductForCommodityDefault extends Create_AnnaDsbUpiRequestBaseProductForCommodity {
		@Override
		protected AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder doEvaluate(NonTransferableProduct product) {
			AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder out = AnnaDsbBaseProduct.builder();
			return assignOutput(out, product);
		}
		
		protected AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder assignOutput(AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder out, NonTransferableProduct product) {
			AnnaDsbNRGY ifThenElseResult8 = null;
			if (areEqual(baseProduct(product), MapperS.of("NRGY"), CardinalityOperator.All).getOrDefault(false)) {
				AnnaDsbAdditionalSubProduct ifThenElseResult0 = null;
				if (areEqual(subProduct(product), MapperS.of("ELEC"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult0 = AnnaDsbAdditionalSubProduct.builder()
						.setAdditionalSubProduct(additionalSubProduct(product).checkedMap("to-enum", AnnaDsbAdditionalSubProductEnum::fromDisplayName, IllegalArgumentException.class).get())
						.build();
				}
				AnnaDsbAdditionalSubProduct ifThenElseResult1 = null;
				if (areEqual(subProduct(product), MapperS.of("OILP"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult1 = AnnaDsbAdditionalSubProduct.builder()
						.setAdditionalSubProduct(additionalSubProduct(product).checkedMap("to-enum", AnnaDsbAdditionalSubProductEnum::fromDisplayName, IllegalArgumentException.class).get())
						.build();
				}
				AnnaDsbAdditionalSubProduct ifThenElseResult2 = null;
				if (areEqual(subProduct(product), MapperS.of("NGAS"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult2 = AnnaDsbAdditionalSubProduct.builder()
						.setAdditionalSubProduct(additionalSubProduct(product).checkedMap("to-enum", AnnaDsbAdditionalSubProductEnum::fromDisplayName, IllegalArgumentException.class).get())
						.build();
				}
				AnnaDsbEmpty ifThenElseResult3 = null;
				if (areEqual(subProduct(product), MapperS.of("LGHT"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult3 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult4 = null;
				if (areEqual(subProduct(product), MapperS.of("RNNG"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult4 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult5 = null;
				if (areEqual(subProduct(product), MapperS.of("DIST"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult5 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult6 = null;
				if (areEqual(subProduct(product), MapperS.of("COAL"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult6 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult7 = null;
				if (areEqual(subProduct(product), MapperS.of("INRG"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult7 = create_AnnaDsbEmpty.evaluate();
				}
				ifThenElseResult8 = AnnaDsbNRGY.builder()
					.setELEC(ifThenElseResult0)
					.setOILP(ifThenElseResult1)
					.setNGAS(ifThenElseResult2)
					.setLGHT(ifThenElseResult3)
					.setRNNG(ifThenElseResult4)
					.setDIST(ifThenElseResult5)
					.setCOAL(ifThenElseResult6)
					.setINRG(ifThenElseResult7)
					.build();
			}
			out
				.setNRGY(ifThenElseResult8);
			
			AnnaDsbAGRI ifThenElseResult18 = null;
			if (areEqual(baseProduct(product), MapperS.of("AGRI"), CardinalityOperator.All).getOrDefault(false)) {
				AnnaDsbAdditionalSubProduct ifThenElseResult9 = null;
				if (areEqual(subProduct(product), MapperS.of("GRIN"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult9 = AnnaDsbAdditionalSubProduct.builder()
						.setAdditionalSubProduct(additionalSubProduct(product).checkedMap("to-enum", AnnaDsbAdditionalSubProductEnum::fromDisplayName, IllegalArgumentException.class).get())
						.build();
				}
				AnnaDsbAdditionalSubProduct ifThenElseResult10 = null;
				if (areEqual(subProduct(product), MapperS.of("OOLI"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult10 = AnnaDsbAdditionalSubProduct.builder()
						.setAdditionalSubProduct(additionalSubProduct(product).checkedMap("to-enum", AnnaDsbAdditionalSubProductEnum::fromDisplayName, IllegalArgumentException.class).get())
						.build();
				}
				AnnaDsbAdditionalSubProduct ifThenElseResult11 = null;
				if (areEqual(subProduct(product), MapperS.of("SOFT"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult11 = AnnaDsbAdditionalSubProduct.builder()
						.setAdditionalSubProduct(additionalSubProduct(product).checkedMap("to-enum", AnnaDsbAdditionalSubProductEnum::fromDisplayName, IllegalArgumentException.class).get())
						.build();
				}
				AnnaDsbAdditionalSubProduct ifThenElseResult12 = null;
				if (areEqual(subProduct(product), MapperS.of("GROS"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult12 = AnnaDsbAdditionalSubProduct.builder()
						.setAdditionalSubProduct(additionalSubProduct(product).checkedMap("to-enum", AnnaDsbAdditionalSubProductEnum::fromDisplayName, IllegalArgumentException.class).get())
						.build();
				}
				AnnaDsbEmpty ifThenElseResult13 = null;
				if (areEqual(subProduct(product), MapperS.of("SEAF"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult13 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult14 = null;
				if (areEqual(subProduct(product), MapperS.of("DIRY"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult14 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult15 = null;
				if (areEqual(subProduct(product), MapperS.of("POTA"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult15 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult16 = null;
				if (areEqual(subProduct(product), MapperS.of("FRST"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult16 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult17 = null;
				if (areEqual(subProduct(product), MapperS.of("LSTK"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult17 = create_AnnaDsbEmpty.evaluate();
				}
				ifThenElseResult18 = AnnaDsbAGRI.builder()
					.setGRIN(ifThenElseResult9)
					.setOOLI(ifThenElseResult10)
					.setSOFT(ifThenElseResult11)
					.setGROS(ifThenElseResult12)
					.setSEAF(ifThenElseResult13)
					.setDIRY(ifThenElseResult14)
					.setPOTA(ifThenElseResult15)
					.setFRST(ifThenElseResult16)
					.setLSTK(ifThenElseResult17)
					.build();
			}
			out
				.setAGRI(ifThenElseResult18);
			
			AnnaDsbENVR ifThenElseResult22 = null;
			if (areEqual(baseProduct(product), MapperS.of("ENVR"), CardinalityOperator.All).getOrDefault(false)) {
				AnnaDsbAdditionalSubProduct ifThenElseResult19 = null;
				if (areEqual(subProduct(product), MapperS.of("EMIS"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult19 = AnnaDsbAdditionalSubProduct.builder()
						.setAdditionalSubProduct(additionalSubProduct(product).checkedMap("to-enum", AnnaDsbAdditionalSubProductEnum::fromDisplayName, IllegalArgumentException.class).get())
						.build();
				}
				AnnaDsbEmpty ifThenElseResult20 = null;
				if (areEqual(subProduct(product), MapperS.of("CRBR"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult20 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult21 = null;
				if (areEqual(subProduct(product), MapperS.of("WTHR"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult21 = create_AnnaDsbEmpty.evaluate();
				}
				ifThenElseResult22 = AnnaDsbENVR.builder()
					.setEMIS(ifThenElseResult19)
					.setCRBR(ifThenElseResult20)
					.setWTHR(ifThenElseResult21)
					.build();
			}
			out
				.setENVR(ifThenElseResult22);
			
			AnnaDsbFRGT ifThenElseResult26 = null;
			if (areEqual(baseProduct(product), MapperS.of("FRGT"), CardinalityOperator.All).getOrDefault(false)) {
				AnnaDsbAdditionalSubProduct ifThenElseResult23 = null;
				if (areEqual(subProduct(product), MapperS.of("WETF"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult23 = AnnaDsbAdditionalSubProduct.builder()
						.setAdditionalSubProduct(additionalSubProduct(product).checkedMap("to-enum", AnnaDsbAdditionalSubProductEnum::fromDisplayName, IllegalArgumentException.class).get())
						.build();
				}
				AnnaDsbAdditionalSubProduct ifThenElseResult24 = null;
				if (areEqual(subProduct(product), MapperS.of("DRYF"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult24 = AnnaDsbAdditionalSubProduct.builder()
						.setAdditionalSubProduct(additionalSubProduct(product).checkedMap("to-enum", AnnaDsbAdditionalSubProductEnum::fromDisplayName, IllegalArgumentException.class).get())
						.build();
				}
				AnnaDsbEmpty ifThenElseResult25 = null;
				if (areEqual(subProduct(product), MapperS.of("CSHP"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult25 = create_AnnaDsbEmpty.evaluate();
				}
				ifThenElseResult26 = AnnaDsbFRGT.builder()
					.setWETF(ifThenElseResult23)
					.setDRYF(ifThenElseResult24)
					.setCSHP(ifThenElseResult25)
					.build();
			}
			out
				.setFRGT(ifThenElseResult26);
			
			AnnaDsbFRTL ifThenElseResult33 = null;
			if (areEqual(baseProduct(product), MapperS.of("FRTL"), CardinalityOperator.All).getOrDefault(false)) {
				AnnaDsbEmpty ifThenElseResult27 = null;
				if (areEqual(subProduct(product), MapperS.of("AMMO"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult27 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult28 = null;
				if (areEqual(subProduct(product), MapperS.of("SLPH"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult28 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult29 = null;
				if (areEqual(subProduct(product), MapperS.of("DAPH"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult29 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult30 = null;
				if (areEqual(subProduct(product), MapperS.of("PTSH"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult30 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult31 = null;
				if (areEqual(subProduct(product), MapperS.of("UREA"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult31 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult32 = null;
				if (areEqual(subProduct(product), MapperS.of("UAAN"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult32 = create_AnnaDsbEmpty.evaluate();
				}
				ifThenElseResult33 = AnnaDsbFRTL.builder()
					.setAMMO(ifThenElseResult27)
					.setSLPH(ifThenElseResult28)
					.setDAPH(ifThenElseResult29)
					.setPTSH(ifThenElseResult30)
					.setUREA(ifThenElseResult31)
					.setUAAN(ifThenElseResult32)
					.build();
			}
			out
				.setFRTL(ifThenElseResult33);
			
			AnnaDsbINDP ifThenElseResult36 = null;
			if (areEqual(baseProduct(product), MapperS.of("INDP"), CardinalityOperator.All).getOrDefault(false)) {
				AnnaDsbEmpty ifThenElseResult34 = null;
				if (areEqual(subProduct(product), MapperS.of("CSTR"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult34 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult35 = null;
				if (areEqual(subProduct(product), MapperS.of("MFTG"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult35 = create_AnnaDsbEmpty.evaluate();
				}
				ifThenElseResult36 = AnnaDsbINDP.builder()
					.setCSTR(ifThenElseResult34)
					.setMFTG(ifThenElseResult35)
					.build();
			}
			out
				.setINDP(ifThenElseResult36);
			
			AnnaDsbMETL ifThenElseResult39 = null;
			if (areEqual(baseProduct(product), MapperS.of("METL"), CardinalityOperator.All).getOrDefault(false)) {
				AnnaDsbAdditionalSubProduct ifThenElseResult37 = null;
				if (areEqual(subProduct(product), MapperS.of("NPRM"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult37 = AnnaDsbAdditionalSubProduct.builder()
						.setAdditionalSubProduct(additionalSubProduct(product).checkedMap("to-enum", AnnaDsbAdditionalSubProductEnum::fromDisplayName, IllegalArgumentException.class).get())
						.build();
				}
				AnnaDsbAdditionalSubProduct ifThenElseResult38 = null;
				if (areEqual(subProduct(product), MapperS.of("PRME"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult38 = AnnaDsbAdditionalSubProduct.builder()
						.setAdditionalSubProduct(additionalSubProduct(product).checkedMap("to-enum", AnnaDsbAdditionalSubProductEnum::fromDisplayName, IllegalArgumentException.class).get())
						.build();
				}
				ifThenElseResult39 = AnnaDsbMETL.builder()
					.setNPRM(ifThenElseResult37)
					.setPRME(ifThenElseResult38)
					.build();
			}
			out
				.setMETL(ifThenElseResult39);
			
			AnnaDsbPAPR ifThenElseResult44 = null;
			if (areEqual(baseProduct(product), MapperS.of("PAPR"), CardinalityOperator.All).getOrDefault(false)) {
				AnnaDsbEmpty ifThenElseResult40 = null;
				if (areEqual(subProduct(product), MapperS.of("PULP"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult40 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult41 = null;
				if (areEqual(subProduct(product), MapperS.of("NSPT"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult41 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult42 = null;
				if (areEqual(subProduct(product), MapperS.of("RCVP"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult42 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult43 = null;
				if (areEqual(subProduct(product), MapperS.of("CBRD"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult43 = create_AnnaDsbEmpty.evaluate();
				}
				ifThenElseResult44 = AnnaDsbPAPR.builder()
					.setPULP(ifThenElseResult40)
					.setNSPT(ifThenElseResult41)
					.setRCVP(ifThenElseResult42)
					.setCBRD(ifThenElseResult43)
					.build();
			}
			out
				.setPAPR(ifThenElseResult44);
			
			AnnaDsbPOLY ifThenElseResult46 = null;
			if (areEqual(baseProduct(product), MapperS.of("POLY"), CardinalityOperator.All).getOrDefault(false)) {
				AnnaDsbEmpty ifThenElseResult45 = null;
				if (areEqual(subProduct(product), MapperS.of("PLST"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult45 = create_AnnaDsbEmpty.evaluate();
				}
				ifThenElseResult46 = AnnaDsbPOLY.builder()
					.setPLST(ifThenElseResult45)
					.build();
			}
			out
				.setPOLY(ifThenElseResult46);
			
			AnnaDsbOTHC ifThenElseResult49 = null;
			if (areEqual(baseProduct(product), MapperS.of("OTHC"), CardinalityOperator.All).getOrDefault(false)) {
				AnnaDsbEmpty ifThenElseResult47 = null;
				if (areEqual(subProduct(product), MapperS.of("DLVR"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult47 = create_AnnaDsbEmpty.evaluate();
				}
				AnnaDsbEmpty ifThenElseResult48 = null;
				if (areEqual(subProduct(product), MapperS.of("NDLV"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult48 = create_AnnaDsbEmpty.evaluate();
				}
				ifThenElseResult49 = AnnaDsbOTHC.builder()
					.setDLVR(ifThenElseResult47)
					.setNDLV(ifThenElseResult48)
					.build();
			}
			out
				.setOTHC(ifThenElseResult49);
			
			AnnaDsbEmpty ifThenElseResult50 = null;
			if (areEqual(baseProduct(product), MapperS.of("OTHR"), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult50 = create_AnnaDsbEmpty.evaluate();
			}
			out
				.setOTHR(ifThenElseResult50);
			
			return Optional.ofNullable(out)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product) {
			return MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
		
		@Override
		protected MapperS<? extends TaxonomyValue> esmaTaxonomy(NonTransferableProduct product) {
			final MapperC<ProductTaxonomy> thenArg0 = MapperS.of(product).<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy())
				.filterItemNullSafe(item -> areEqual(item.<TaxonomySourceEnum>map("getSource", productTaxonomy -> productTaxonomy.getSource()), MapperS.of(TaxonomySourceEnum.EMIR), CardinalityOperator.All).get());
			final MapperC<TaxonomyValue> thenArg1 = thenArg0
				.mapItem(item -> item.<TaxonomyValue>map("getValue", productTaxonomy -> productTaxonomy.getValue()));
			final MapperC<TaxonomyValue> thenArg2 = thenArg1
				.filterItemNullSafe(item -> exists(item.<TaxonomyClassification>mapC("getClassification", taxonomyValue -> taxonomyValue.getClassification())).get());
			return MapperS.of(distinctIgnoringPrecision(thenArg2).get());
		}
		
		@Override
		protected MapperS<String> baseProduct(NonTransferableProduct product) {
			return MapperS.of(getClassificationValueByOrdinal.evaluate(esmaTaxonomy(product).get(), 1));
		}
		
		@Override
		protected MapperS<String> subProduct(NonTransferableProduct product) {
			return MapperS.of(getClassificationValueByOrdinal.evaluate(esmaTaxonomy(product).get(), 2));
		}
		
		@Override
		protected MapperS<String> additionalSubProduct(NonTransferableProduct product) {
			return MapperS.of(getClassificationValueByOrdinal.evaluate(esmaTaxonomy(product).get(), 3));
		}
	}
}
