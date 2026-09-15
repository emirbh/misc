package drr.regulation.common.functions;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.product.qualification.functions.Qualify_BaseProduct_Inflation;
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.qualification.functions.Qualify_Commodity_Option;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Index;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_IndexTranche;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Loan;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_SingleName;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwaption;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDF;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDS;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Spot_Forward;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Swap;
import cdm.product.qualification.functions.Qualify_ForeignExchange_VanillaOption;
import cdm.product.qualification.functions.Qualify_InterestRate_CapFloor;
import cdm.product.qualification.functions.Qualify_InterestRate_CrossCurrency_Basis;
import cdm.product.qualification.functions.Qualify_InterestRate_CrossCurrency_FixedFixed;
import cdm.product.qualification.functions.Qualify_InterestRate_CrossCurrency_FixedFloat;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_Basis;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_Basis_OIS;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFixed;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFloat;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFloat_OIS;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_Basis_YearOn_Year;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_Basis_ZeroCoupon;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon;
import cdm.product.qualification.functions.Qualify_InterestRate_Option_DebtOption;
import cdm.product.qualification.functions.Qualify_InterestRate_Option_Swaption;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.base.util.string.functions.StringContains;
import drr.standards.iosco.upi.AnnaDsbUseCaseEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetDSBRecord.GetDSBRecordDefault.class)
public abstract class GetDSBRecord implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_BaseProduct_Inflation qualify_BaseProduct_Inflation;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;
	@Inject protected Qualify_Commodity_Option qualify_Commodity_Option;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;
	@Inject protected Qualify_CreditDefaultSwap_Index qualify_CreditDefaultSwap_Index;
	@Inject protected Qualify_CreditDefaultSwap_IndexTranche qualify_CreditDefaultSwap_IndexTranche;
	@Inject protected Qualify_CreditDefaultSwap_Loan qualify_CreditDefaultSwap_Loan;
	@Inject protected Qualify_CreditDefaultSwap_SingleName qualify_CreditDefaultSwap_SingleName;
	@Inject protected Qualify_CreditDefaultSwaption qualify_CreditDefaultSwaption;
	@Inject protected Qualify_ForeignExchange_NDF qualify_ForeignExchange_NDF;
	@Inject protected Qualify_ForeignExchange_NDS qualify_ForeignExchange_NDS;
	@Inject protected Qualify_ForeignExchange_Spot_Forward qualify_ForeignExchange_Spot_Forward;
	@Inject protected Qualify_ForeignExchange_Swap qualify_ForeignExchange_Swap;
	@Inject protected Qualify_ForeignExchange_VanillaOption qualify_ForeignExchange_VanillaOption;
	@Inject protected Qualify_InterestRate_CapFloor qualify_InterestRate_CapFloor;
	@Inject protected Qualify_InterestRate_CrossCurrency_Basis qualify_InterestRate_CrossCurrency_Basis;
	@Inject protected Qualify_InterestRate_CrossCurrency_FixedFixed qualify_InterestRate_CrossCurrency_FixedFixed;
	@Inject protected Qualify_InterestRate_CrossCurrency_FixedFloat qualify_InterestRate_CrossCurrency_FixedFloat;
	@Inject protected Qualify_InterestRate_IRSwap_Basis qualify_InterestRate_IRSwap_Basis;
	@Inject protected Qualify_InterestRate_IRSwap_Basis_OIS qualify_InterestRate_IRSwap_Basis_OIS;
	@Inject protected Qualify_InterestRate_IRSwap_FixedFixed qualify_InterestRate_IRSwap_FixedFixed;
	@Inject protected Qualify_InterestRate_IRSwap_FixedFloat qualify_InterestRate_IRSwap_FixedFloat;
	@Inject protected Qualify_InterestRate_IRSwap_FixedFloat_OIS qualify_InterestRate_IRSwap_FixedFloat_OIS;
	@Inject protected Qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon;
	@Inject protected Qualify_InterestRate_InflationSwap_Basis_YearOn_Year qualify_InterestRate_InflationSwap_Basis_YearOn_Year;
	@Inject protected Qualify_InterestRate_InflationSwap_Basis_ZeroCoupon qualify_InterestRate_InflationSwap_Basis_ZeroCoupon;
	@Inject protected Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year;
	@Inject protected Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon;
	@Inject protected Qualify_InterestRate_Option_DebtOption qualify_InterestRate_Option_DebtOption;
	@Inject protected Qualify_InterestRate_Option_Swaption qualify_InterestRate_Option_Swaption;
	@Inject protected StringContains stringContains;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param reportableEvent 
	* @return useCase 
	*/
	public AnnaDsbUseCaseEnum evaluate(ReportableEventBase reportableEvent) {
		AnnaDsbUseCaseEnum useCase = doEvaluate(reportableEvent);
		
		return useCase;
	}

	protected abstract AnnaDsbUseCaseEnum doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends FieldWithMetaString> isdaTaxonomy(ReportableEventBase reportableEvent);

	public static class GetDSBRecordDefault extends GetDSBRecord {
		@Override
		protected AnnaDsbUseCaseEnum doEvaluate(ReportableEventBase reportableEvent) {
			AnnaDsbUseCaseEnum useCase = null;
			return assignOutput(useCase, reportableEvent);
		}
		
		protected AnnaDsbUseCaseEnum assignOutput(AnnaDsbUseCaseEnum useCase, ReportableEventBase reportableEvent) {
			if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), MapperS.of("ForeignExchange:SimpleExotic:Digital"), CardinalityOperator.All).getOrDefault(false)) {
				useCase = AnnaDsbUseCaseEnum.DIGITAL_OPTION;
			} else if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), MapperS.of("ForeignExchange:SimpleExotic:Barrier"), CardinalityOperator.All).getOrDefault(false)) {
				useCase = AnnaDsbUseCaseEnum.BARRIER_OPTION;
			} else if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString2 -> fieldWithMetaString2 == null ? null : fieldWithMetaString2.getValue()), MapperS.of("ForeignExchange:NDO"), CardinalityOperator.All).getOrDefault(false)) {
				useCase = AnnaDsbUseCaseEnum.NDO;
			} else if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString3 -> fieldWithMetaString3 == null ? null : fieldWithMetaString3.getValue()), MapperS.of("ForeignExchange:ComplexExotic"), CardinalityOperator.All).getOrDefault(false)) {
				useCase = AnnaDsbUseCaseEnum.NON_STANDARD;
			} else {
				final Boolean boolean0 = qualify_ForeignExchange_VanillaOption.evaluate(economicTerms(reportableEvent).get());
				if ((boolean0 == null ? false : boolean0)) {
					useCase = AnnaDsbUseCaseEnum.VANILLA_OPTION;
				} else {
					final Boolean boolean1 = qualify_ForeignExchange_Spot_Forward.evaluate(economicTerms(reportableEvent).get());
					if ((boolean1 == null ? false : boolean1)) {
						useCase = AnnaDsbUseCaseEnum.FORWARD;
					} else {
						final Boolean boolean2 = qualify_ForeignExchange_Swap.evaluate(economicTerms(reportableEvent).get());
						if ((boolean2 == null ? false : boolean2)) {
							useCase = AnnaDsbUseCaseEnum.FX_SWAP;
						} else {
							final Boolean boolean3 = qualify_ForeignExchange_NDS.evaluate(economicTerms(reportableEvent).get());
							if ((boolean3 == null ? false : boolean3)) {
								useCase = AnnaDsbUseCaseEnum.NON_DELIVERABLE_FX_SWAP;
							} else {
								final Boolean boolean4 = qualify_ForeignExchange_NDF.evaluate(economicTerms(reportableEvent).get());
								if ((boolean4 == null ? false : boolean4)) {
									useCase = AnnaDsbUseCaseEnum.NDF;
								} else if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString4 -> fieldWithMetaString4 == null ? null : fieldWithMetaString4.getValue()), MapperS.of("InterestRate:Exotic"), CardinalityOperator.All).getOrDefault(false)) {
									useCase = AnnaDsbUseCaseEnum.NON_STANDARD;
								} else if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString5 -> fieldWithMetaString5 == null ? null : fieldWithMetaString5.getValue()), MapperS.of("InterestRate:Forward:Debt"), CardinalityOperator.All).getOrDefault(false)) {
									useCase = AnnaDsbUseCaseEnum.DEBT;
								} else if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString6 -> fieldWithMetaString6 == null ? null : fieldWithMetaString6.getValue()), MapperS.of("InterestRate:FRA"), CardinalityOperator.All).getOrDefault(false)) {
									useCase = AnnaDsbUseCaseEnum.FRA_INDEX;
								} else {
									final Boolean boolean5 = qualify_InterestRate_IRSwap_FixedFloat.evaluate(economicTerms(reportableEvent).get());
									if ((boolean5 == null ? false : boolean5)) {
										useCase = AnnaDsbUseCaseEnum.FIXED_FLOAT;
									} else {
										final Boolean boolean6 = qualify_InterestRate_IRSwap_FixedFixed.evaluate(economicTerms(reportableEvent).get());
										if ((boolean6 == null ? false : boolean6)) {
											useCase = AnnaDsbUseCaseEnum.FIXED_FIXED;
										} else {
											final Boolean boolean7 = qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year.evaluate(economicTerms(reportableEvent).get());
											if ((boolean7 == null ? false : boolean7)) {
												useCase = AnnaDsbUseCaseEnum.INFLATION_FIXED_FLOAT_YO_Y;
											} else {
												final Boolean boolean8 = qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon.evaluate(economicTerms(reportableEvent).get());
												if ((boolean8 == null ? false : boolean8)) {
													useCase = AnnaDsbUseCaseEnum.INFLATION_FIXED_FLOAT_ZERO_COUPON;
												} else {
													final Boolean boolean9 = qualify_InterestRate_InflationSwap_Basis_YearOn_Year.evaluate(economicTerms(reportableEvent).get());
													if ((boolean9 == null ? false : boolean9)) {
														useCase = AnnaDsbUseCaseEnum.INFLATION_BASIS_YO_Y;
													} else {
														final Boolean boolean10 = qualify_InterestRate_InflationSwap_Basis_ZeroCoupon.evaluate(economicTerms(reportableEvent).get());
														if ((boolean10 == null ? false : boolean10)) {
															useCase = AnnaDsbUseCaseEnum.INFLATION_BASIS_ZERO_COUPON;
														} else {
															final Boolean boolean11 = qualify_BaseProduct_Inflation.evaluate(economicTerms(reportableEvent).get());
															if ((boolean11 == null ? false : boolean11)) {
																useCase = AnnaDsbUseCaseEnum.INFLATION_SWAP;
															} else {
																final Boolean boolean12 = qualify_InterestRate_CrossCurrency_FixedFixed.evaluate(economicTerms(reportableEvent).get());
																if ((boolean12 == null ? false : boolean12)) {
																	useCase = AnnaDsbUseCaseEnum.CROSS_CURRENCY_FIXED_FIXED;
																} else {
																	final Boolean boolean13 = qualify_InterestRate_CrossCurrency_FixedFloat.evaluate(economicTerms(reportableEvent).get());
																	if ((boolean13 == null ? false : boolean13)) {
																		useCase = AnnaDsbUseCaseEnum.CROSS_CURRENCY_FIXED_FLOAT;
																	} else {
																		final Boolean boolean14 = qualify_InterestRate_IRSwap_Basis.evaluate(economicTerms(reportableEvent).get());
																		if ((boolean14 == null ? false : boolean14)) {
																			useCase = AnnaDsbUseCaseEnum.BASIS;
																		} else {
																			final Boolean boolean15 = qualify_InterestRate_IRSwap_Basis_OIS.evaluate(economicTerms(reportableEvent).get());
																			if ((boolean15 == null ? false : boolean15)) {
																				useCase = AnnaDsbUseCaseEnum.BASIS_OIS;
																			} else {
																				final Boolean boolean16 = qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon.evaluate(economicTerms(reportableEvent).get());
																				if ((boolean16 == null ? false : boolean16)) {
																					useCase = AnnaDsbUseCaseEnum.FIXED_FLOAT_ZERO_COUPON;
																				} else {
																					final Boolean boolean17 = qualify_InterestRate_IRSwap_FixedFloat_OIS.evaluate(economicTerms(reportableEvent).get());
																					if ((boolean17 == null ? false : boolean17)) {
																						useCase = AnnaDsbUseCaseEnum.FIXED_FLOAT_OIS;
																					} else {
																						final Boolean boolean18 = qualify_InterestRate_CrossCurrency_Basis.evaluate(economicTerms(reportableEvent).get());
																						if ((boolean18 == null ? false : boolean18)) {
																							useCase = AnnaDsbUseCaseEnum.CROSS_CURRENCY_BASIS;
																						} else {
																							final Boolean boolean19 = qualify_InterestRate_Option_Swaption.evaluate(economicTerms(reportableEvent).get());
																							if ((boolean19 == null ? false : boolean19)) {
																								useCase = AnnaDsbUseCaseEnum.SWAPTION;
																							} else {
																								final Boolean boolean20 = qualify_InterestRate_CapFloor.evaluate(economicTerms(reportableEvent).get());
																								if ((boolean20 == null ? false : boolean20)) {
																									useCase = AnnaDsbUseCaseEnum.CAP_FLOOR;
																								} else {
																									final Boolean boolean21 = qualify_InterestRate_Option_DebtOption.evaluate(economicTerms(reportableEvent).get());
																									if ((boolean21 == null ? false : boolean21)) {
																										useCase = AnnaDsbUseCaseEnum.DEBT_OPTION;
																									} else {
																										final Boolean boolean22 = qualify_CreditDefaultSwap_Loan.evaluate(economicTerms(reportableEvent).get());
																										if ((boolean22 == null ? false : boolean22)) {
																											useCase = AnnaDsbUseCaseEnum.LOAN;
																										} else {
																											final Boolean boolean23 = qualify_CreditDefaultSwap_Index.evaluate(economicTerms(reportableEvent).get());
																											if ((boolean23 == null ? false : boolean23)) {
																												useCase = AnnaDsbUseCaseEnum.INDEX;
																											} else {
																												final Boolean boolean24 = qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(reportableEvent).get());
																												if ((boolean24 == null ? false : boolean24)) {
																													useCase = AnnaDsbUseCaseEnum.INDEX_TRANCHE;
																												} else {
																													final Boolean boolean25 = qualify_CreditDefaultSwaption.evaluate(economicTerms(reportableEvent).get());
																													if ((boolean25 == null ? false : boolean25)) {
																														final Boolean boolean26 = qualify_CreditDefaultSwap_SingleName.evaluate(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
																														if ((boolean26 == null ? false : boolean26)) {
																															useCase = AnnaDsbUseCaseEnum.SINGLE_NAME_SWAPTION;
																														} else {
																															final Boolean boolean27 = qualify_CreditDefaultSwap_Index.evaluate(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
																															if ((boolean27 == null ? false : boolean27)) {
																																useCase = AnnaDsbUseCaseEnum.INDEX_SWAPTION;
																															} else {
																																useCase = null;
																															}
																														}
																													} else {
																														final FieldWithMetaString fieldWithMetaString7 = isdaTaxonomy(reportableEvent).get();
																														final Boolean boolean28 = stringContains.evaluate((fieldWithMetaString7 == null ? null : fieldWithMetaString7.getValue()), "^Credit:SingleName:Corporate:.*");
																														if ((boolean28 == null ? false : boolean28)) {
																															useCase = AnnaDsbUseCaseEnum.CORPORATE;
																														} else {
																															final FieldWithMetaString fieldWithMetaString8 = isdaTaxonomy(reportableEvent).get();
																															final Boolean boolean29 = stringContains.evaluate((fieldWithMetaString8 == null ? null : fieldWithMetaString8.getValue()), "^Credit:SingleName:Sovereign:.*");
																															if ((boolean29 == null ? false : boolean29)) {
																																useCase = AnnaDsbUseCaseEnum.SOVEREIGN;
																															} else {
																																final FieldWithMetaString fieldWithMetaString9 = isdaTaxonomy(reportableEvent).get();
																																final Boolean boolean30 = stringContains.evaluate((fieldWithMetaString9 == null ? null : fieldWithMetaString9.getValue()), "^Credit:SingleName:Muni:.*");
																																if ((boolean30 == null ? false : boolean30)) {
																																	useCase = AnnaDsbUseCaseEnum.MUNICIPAL;
																																} else {
																																	final FieldWithMetaString fieldWithMetaString10 = isdaTaxonomy(reportableEvent).get();
																																	final Boolean boolean31 = stringContains.evaluate((fieldWithMetaString10 == null ? null : fieldWithMetaString10.getValue()), "^Credit:TotalReturnSwap.*");
																																	if ((boolean31 == null ? false : boolean31)) {
																																		useCase = AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP;
																																	} else {
																																		final FieldWithMetaString fieldWithMetaString11 = isdaTaxonomy(reportableEvent).get();
																																		final Boolean boolean32 = stringContains.evaluate((fieldWithMetaString11 == null ? null : fieldWithMetaString11.getValue()), "^Credit:Exotic.*");
																																		if ((boolean32 == null ? false : boolean32)) {
																																			useCase = AnnaDsbUseCaseEnum.NON_STANDARD;
																																		} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
																																			useCase = AnnaDsbUseCaseEnum.SWAP;
																																		} else {
																																			final Boolean boolean33 = qualify_Commodity_Swaption.evaluate(economicTerms(reportableEvent).get());
																																			if ((boolean33 == null ? false : boolean33)) {
																																				useCase = AnnaDsbUseCaseEnum.SWAPTION;
																																			} else {
																																				final Boolean boolean34 = qualify_Commodity_Option.evaluate(economicTerms(reportableEvent).get());
																																				if ((boolean34 == null ? false : boolean34)) {
																																					useCase = AnnaDsbUseCaseEnum.OPTION;
																																				} else {
																																					final Boolean boolean35 = qualify_Commodity_Forward.evaluate(economicTerms(reportableEvent).get());
																																					if ((boolean35 == null ? false : boolean35)) {
																																						useCase = AnnaDsbUseCaseEnum.FORWARD;
																																					} else {
																																						useCase = null;
																																					}
																																				}
																																			}
																																		}
																																	}
																																}
																															}
																														}
																													}
																												}
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			return useCase;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			return MapperS.of(productForEvent.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent) {
			return product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> isdaTaxonomy(ReportableEventBase reportableEvent) {
			final MapperC<ProductTaxonomy> thenArg0 = product(reportableEvent).<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy())
				.filterItemNullSafe(item -> areEqual(item.<TaxonomySourceEnum>map("getSource", productTaxonomy -> productTaxonomy.getSource()), MapperS.of(TaxonomySourceEnum.ISDA), CardinalityOperator.All).andNullSafe(exists(item.<TaxonomyValue>map("getValue", productTaxonomy -> productTaxonomy.getValue()).<FieldWithMetaString>map("getName", taxonomyValue -> taxonomyValue.getName()))).get());
			final MapperS<ProductTaxonomy> thenArg1 = thenArg0
				.first();
			return thenArg1.<TaxonomyValue>map("getValue", productTaxonomy -> productTaxonomy.getValue()).<FieldWithMetaString>map("getName", taxonomyValue -> taxonomyValue.getName());
		}
	}
}
