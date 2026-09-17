package fpml.consolidated.com;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.meta.EnvironmentalPhysicalLegMeta;
import fpml.consolidated.fpmlenum.EnvironmentalAbandonmentOfSchemeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.DateOffset;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Physically settled environmental leg.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Physically settled environmental leg.
 *
 */
@RosettaDataType(value="EnvironmentalPhysicalLeg", builder=EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EnvironmentalPhysicalLeg", model="fpml", builder=EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilderImpl.class, version="2.1.1")
public interface EnvironmentalPhysicalLeg extends PhysicalSwapLeg {

	EnvironmentalPhysicalLegMeta metaData = new EnvironmentalPhysicalLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of allowances, certificates or credit to be transaction in the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of allowances, certificates or credit to be transaction in the transaction.
	 *
	 */
	UnitQuantity getNumberOfAllowances();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specification of the type of allowance or credit.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification of the type of allowance or credit.
	 *
	 */
	EnvironmentalProduct getEnvironmental();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Applies to U.S. Emissions Allowance Transactions. Specifies terms which apply in the event of an Abandonment of Scheme event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Applies to U.S. Emissions Allowance Transactions. Specifies terms which apply in the event of an Abandonment of Scheme event.
	 *
	 */
	EnvironmentalAbandonmentOfSchemeEnum getAbandonmentOfScheme();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which allowances are to be delivered as specified in the related Confirmation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which allowances are to be delivered as specified in the related Confirmation.
	 *
	 */
	AdjustableOrRelativeDate getDeliveryDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	DateOffset getPaymentDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 *
	 */
	BusinessCentersReference getBusinessCentersReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	BusinessCenters getBusinessCenters();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Applies to EU Emissions Allowance Transactions. Holds the Failure to Deliver (Alternative Method) election. Used to determine how provisions in Part [7] Page 7 (B) Failure to Deliver Not Remedied are to be applied.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Applies to EU Emissions Allowance Transactions. Holds the Failure to Deliver (Alternative Method) election. Used to determine how provisions in Part [7] Page 7 (B) Failure to Deliver Not Remedied are to be applied.
	 *
	 */
	Boolean getFailureToDeliverApplicable();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Applies to EU Emissions Allowance Transactions. Contains a series of parameters controlling Excess Emissions Penalty payments.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Applies to EU Emissions Allowance Transactions. Contains a series of parameters controlling Excess Emissions Penalty payments.
	 *
	 */
	EEPParameters getEEPParameters();

	/*********************** Build Methods  ***********************/
	EnvironmentalPhysicalLeg build();
	
	EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder toBuilder();
	
	static EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder builder() {
		return new EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnvironmentalPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnvironmentalPhysicalLeg> getType() {
		return EnvironmentalPhysicalLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.class, getCommodityClassification());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("numberOfAllowances"), processor, UnitQuantity.class, getNumberOfAllowances());
		processRosetta(path.newSubPath("environmental"), processor, EnvironmentalProduct.class, getEnvironmental());
		processor.processBasic(path.newSubPath("abandonmentOfScheme"), EnvironmentalAbandonmentOfSchemeEnum.class, getAbandonmentOfScheme(), this);
		processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableOrRelativeDate.class, getDeliveryDate());
		processRosetta(path.newSubPath("paymentDate"), processor, DateOffset.class, getPaymentDate());
		processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
		processor.processBasic(path.newSubPath("failureToDeliverApplicable"), Boolean.class, getFailureToDeliverApplicable(), this);
		processRosetta(path.newSubPath("eEPParameters"), processor, EEPParameters.class, getEEPParameters());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnvironmentalPhysicalLegBuilder extends EnvironmentalPhysicalLeg, PhysicalSwapLeg.PhysicalSwapLegBuilder {
		UnitQuantity.UnitQuantityBuilder getOrCreateNumberOfAllowances();
		@Override
		UnitQuantity.UnitQuantityBuilder getNumberOfAllowances();
		EnvironmentalProduct.EnvironmentalProductBuilder getOrCreateEnvironmental();
		@Override
		EnvironmentalProduct.EnvironmentalProductBuilder getEnvironmental();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateDeliveryDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getDeliveryDate();
		DateOffset.DateOffsetBuilder getOrCreatePaymentDate();
		@Override
		DateOffset.DateOffsetBuilder getPaymentDate();
		BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference();
		@Override
		BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference();
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		@Override
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		EEPParameters.EEPParametersBuilder getOrCreateEEPParameters();
		@Override
		EEPParameters.EEPParametersBuilder getEEPParameters();
		@Override
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setId(String id);
		@Override
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification);
		@Override
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification, int idx);
		@Override
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setNumberOfAllowances(UnitQuantity numberOfAllowances);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setEnvironmental(EnvironmentalProduct environmental);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setAbandonmentOfScheme(EnvironmentalAbandonmentOfSchemeEnum abandonmentOfScheme);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setDeliveryDate(AdjustableOrRelativeDate deliveryDate);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setPaymentDate(DateOffset paymentDate);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setBusinessCentersReference(BusinessCentersReference businessCentersReference);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setBusinessCenters(BusinessCenters businessCenters);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setFailureToDeliverApplicable(Boolean failureToDeliverApplicable);
		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setEEPParameters(EEPParameters eEPParameters);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.CommodityClassificationBuilder.class, getCommodityClassification());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("numberOfAllowances"), processor, UnitQuantity.UnitQuantityBuilder.class, getNumberOfAllowances());
			processRosetta(path.newSubPath("environmental"), processor, EnvironmentalProduct.EnvironmentalProductBuilder.class, getEnvironmental());
			processor.processBasic(path.newSubPath("abandonmentOfScheme"), EnvironmentalAbandonmentOfSchemeEnum.class, getAbandonmentOfScheme(), this);
			processRosetta(path.newSubPath("deliveryDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getDeliveryDate());
			processRosetta(path.newSubPath("paymentDate"), processor, DateOffset.DateOffsetBuilder.class, getPaymentDate());
			processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.BusinessCentersReferenceBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processor.processBasic(path.newSubPath("failureToDeliverApplicable"), Boolean.class, getFailureToDeliverApplicable(), this);
			processRosetta(path.newSubPath("eEPParameters"), processor, EEPParameters.EEPParametersBuilder.class, getEEPParameters());
		}
		

		EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of EnvironmentalPhysicalLeg  ***********************/
	class EnvironmentalPhysicalLegImpl extends PhysicalSwapLeg.PhysicalSwapLegImpl implements EnvironmentalPhysicalLeg {
		private final UnitQuantity numberOfAllowances;
		private final EnvironmentalProduct environmental;
		private final EnvironmentalAbandonmentOfSchemeEnum abandonmentOfScheme;
		private final AdjustableOrRelativeDate deliveryDate;
		private final DateOffset paymentDate;
		private final BusinessCentersReference businessCentersReference;
		private final BusinessCenters businessCenters;
		private final Boolean failureToDeliverApplicable;
		private final EEPParameters eEPParameters;
		
		protected EnvironmentalPhysicalLegImpl(EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder builder) {
			super(builder);
			this.numberOfAllowances = ofNullable(builder.getNumberOfAllowances()).map(f->f.build()).orElse(null);
			this.environmental = ofNullable(builder.getEnvironmental()).map(f->f.build()).orElse(null);
			this.abandonmentOfScheme = builder.getAbandonmentOfScheme();
			this.deliveryDate = ofNullable(builder.getDeliveryDate()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.businessCentersReference = ofNullable(builder.getBusinessCentersReference()).map(f->f.build()).orElse(null);
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
			this.failureToDeliverApplicable = builder.getFailureToDeliverApplicable();
			this.eEPParameters = ofNullable(builder.getEEPParameters()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("numberOfAllowances")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberOfAllowances")
		public UnitQuantity getNumberOfAllowances() {
			return numberOfAllowances;
		}
		
		@Override
		@RosettaAttribute("environmental")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("environmental")
		public EnvironmentalProduct getEnvironmental() {
			return environmental;
		}
		
		@Override
		@RosettaAttribute("abandonmentOfScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("abandonmentOfScheme")
		public EnvironmentalAbandonmentOfSchemeEnum getAbandonmentOfScheme() {
			return abandonmentOfScheme;
		}
		
		@Override
		@RosettaAttribute("deliveryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDate")
		public AdjustableOrRelativeDate getDeliveryDate() {
			return deliveryDate;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDate")
		public DateOffset getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCentersReference")
		public BusinessCentersReference getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenters")
		public BusinessCenters getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		@RosettaAttribute("failureToDeliverApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("failureToDeliverApplicable")
		public Boolean getFailureToDeliverApplicable() {
			return failureToDeliverApplicable;
		}
		
		@Override
		@RosettaAttribute("eEPParameters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eEPParameters")
		public EEPParameters getEEPParameters() {
			return eEPParameters;
		}
		
		@Override
		public EnvironmentalPhysicalLeg build() {
			return this;
		}
		
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder toBuilder() {
			EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNumberOfAllowances()).ifPresent(builder::setNumberOfAllowances);
			ofNullable(getEnvironmental()).ifPresent(builder::setEnvironmental);
			ofNullable(getAbandonmentOfScheme()).ifPresent(builder::setAbandonmentOfScheme);
			ofNullable(getDeliveryDate()).ifPresent(builder::setDeliveryDate);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
			ofNullable(getFailureToDeliverApplicable()).ifPresent(builder::setFailureToDeliverApplicable);
			ofNullable(getEEPParameters()).ifPresent(builder::setEEPParameters);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EnvironmentalPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(numberOfAllowances, _that.getNumberOfAllowances())) return false;
			if (!Objects.equals(environmental, _that.getEnvironmental())) return false;
			if (!Objects.equals(abandonmentOfScheme, _that.getAbandonmentOfScheme())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(failureToDeliverApplicable, _that.getFailureToDeliverApplicable())) return false;
			if (!Objects.equals(eEPParameters, _that.getEEPParameters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (numberOfAllowances != null ? numberOfAllowances.hashCode() : 0);
			_result = 31 * _result + (environmental != null ? environmental.hashCode() : 0);
			_result = 31 * _result + (abandonmentOfScheme != null ? abandonmentOfScheme.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (failureToDeliverApplicable != null ? failureToDeliverApplicable.hashCode() : 0);
			_result = 31 * _result + (eEPParameters != null ? eEPParameters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalPhysicalLeg {" +
				"numberOfAllowances=" + this.numberOfAllowances + ", " +
				"environmental=" + this.environmental + ", " +
				"abandonmentOfScheme=" + this.abandonmentOfScheme + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"failureToDeliverApplicable=" + this.failureToDeliverApplicable + ", " +
				"eEPParameters=" + this.eEPParameters +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EnvironmentalPhysicalLeg  ***********************/
	class EnvironmentalPhysicalLegBuilderImpl extends PhysicalSwapLeg.PhysicalSwapLegBuilderImpl implements EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder {
	
		protected UnitQuantity.UnitQuantityBuilder numberOfAllowances;
		protected EnvironmentalProduct.EnvironmentalProductBuilder environmental;
		protected EnvironmentalAbandonmentOfSchemeEnum abandonmentOfScheme;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder deliveryDate;
		protected DateOffset.DateOffsetBuilder paymentDate;
		protected BusinessCentersReference.BusinessCentersReferenceBuilder businessCentersReference;
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		protected Boolean failureToDeliverApplicable;
		protected EEPParameters.EEPParametersBuilder eEPParameters;
		
		@Override
		@RosettaAttribute("numberOfAllowances")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberOfAllowances")
		public UnitQuantity.UnitQuantityBuilder getNumberOfAllowances() {
			return numberOfAllowances;
		}
		
		@Override
		public UnitQuantity.UnitQuantityBuilder getOrCreateNumberOfAllowances() {
			UnitQuantity.UnitQuantityBuilder result;
			if (numberOfAllowances!=null) {
				result = numberOfAllowances;
			}
			else {
				result = numberOfAllowances = UnitQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("environmental")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("environmental")
		public EnvironmentalProduct.EnvironmentalProductBuilder getEnvironmental() {
			return environmental;
		}
		
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder getOrCreateEnvironmental() {
			EnvironmentalProduct.EnvironmentalProductBuilder result;
			if (environmental!=null) {
				result = environmental;
			}
			else {
				result = environmental = EnvironmentalProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("abandonmentOfScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("abandonmentOfScheme")
		public EnvironmentalAbandonmentOfSchemeEnum getAbandonmentOfScheme() {
			return abandonmentOfScheme;
		}
		
		@Override
		@RosettaAttribute("deliveryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getDeliveryDate() {
			return deliveryDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateDeliveryDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (deliveryDate!=null) {
				result = deliveryDate;
			}
			else {
				result = deliveryDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDate")
		public DateOffset.DateOffsetBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public DateOffset.DateOffsetBuilder getOrCreatePaymentDate() {
			DateOffset.DateOffsetBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = DateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCentersReference")
		public BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		public BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference() {
			BusinessCentersReference.BusinessCentersReferenceBuilder result;
			if (businessCentersReference!=null) {
				result = businessCentersReference;
			}
			else {
				result = businessCentersReference = BusinessCentersReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenters")
		public BusinessCenters.BusinessCentersBuilder getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters() {
			BusinessCenters.BusinessCentersBuilder result;
			if (businessCenters!=null) {
				result = businessCenters;
			}
			else {
				result = businessCenters = BusinessCenters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("failureToDeliverApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("failureToDeliverApplicable")
		public Boolean getFailureToDeliverApplicable() {
			return failureToDeliverApplicable;
		}
		
		@Override
		@RosettaAttribute("eEPParameters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eEPParameters")
		public EEPParameters.EEPParametersBuilder getEEPParameters() {
			return eEPParameters;
		}
		
		@Override
		public EEPParameters.EEPParametersBuilder getOrCreateEEPParameters() {
			EEPParameters.EEPParametersBuilder result;
			if (eEPParameters!=null) {
				result = eEPParameters;
			}
			else {
				result = eEPParameters = EEPParameters.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification) {
			if (_commodityClassification != null) {
				this.commodityClassification.add(_commodityClassification.toBuilder());
			}
			return this;
		}
		
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification, int idx) {
			getIndex(this.commodityClassification, idx, () -> _commodityClassification.toBuilder());
			return this;
		}
		
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
			if (commodityClassifications != null) {
				for (final CommodityClassification toAdd : commodityClassifications) {
					this.commodityClassification.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
			if (commodityClassifications == null) {
				this.commodityClassification = new ArrayList<>();
			} else {
				this.commodityClassification = commodityClassifications.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("numberOfAllowances")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("numberOfAllowances")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setNumberOfAllowances(UnitQuantity _numberOfAllowances) {
			this.numberOfAllowances = _numberOfAllowances == null ? null : _numberOfAllowances.toBuilder();
			return this;
		}
		
		@RosettaAttribute("environmental")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("environmental")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setEnvironmental(EnvironmentalProduct _environmental) {
			this.environmental = _environmental == null ? null : _environmental.toBuilder();
			return this;
		}
		
		@RosettaAttribute("abandonmentOfScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("abandonmentOfScheme")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setAbandonmentOfScheme(EnvironmentalAbandonmentOfSchemeEnum _abandonmentOfScheme) {
			this.abandonmentOfScheme = _abandonmentOfScheme == null ? null : _abandonmentOfScheme;
			return this;
		}
		
		@RosettaAttribute("deliveryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryDate")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setDeliveryDate(AdjustableOrRelativeDate _deliveryDate) {
			this.deliveryDate = _deliveryDate == null ? null : _deliveryDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDate")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setPaymentDate(DateOffset _paymentDate) {
			this.paymentDate = _paymentDate == null ? null : _paymentDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCentersReference")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setBusinessCentersReference(BusinessCentersReference _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@RosettaAttribute("failureToDeliverApplicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("failureToDeliverApplicable")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setFailureToDeliverApplicable(Boolean _failureToDeliverApplicable) {
			this.failureToDeliverApplicable = _failureToDeliverApplicable == null ? null : _failureToDeliverApplicable;
			return this;
		}
		
		@RosettaAttribute("eEPParameters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eEPParameters")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder setEEPParameters(EEPParameters _eEPParameters) {
			this.eEPParameters = _eEPParameters == null ? null : _eEPParameters.toBuilder();
			return this;
		}
		
		@Override
		public EnvironmentalPhysicalLeg build() {
			return new EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegImpl(this);
		}
		
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder prune() {
			super.prune();
			if (numberOfAllowances!=null && !numberOfAllowances.prune().hasData()) numberOfAllowances = null;
			if (environmental!=null && !environmental.prune().hasData()) environmental = null;
			if (deliveryDate!=null && !deliveryDate.prune().hasData()) deliveryDate = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			if (eEPParameters!=null && !eEPParameters.prune().hasData()) eEPParameters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNumberOfAllowances()!=null && getNumberOfAllowances().hasData()) return true;
			if (getEnvironmental()!=null && getEnvironmental().hasData()) return true;
			if (getAbandonmentOfScheme()!=null) return true;
			if (getDeliveryDate()!=null && getDeliveryDate().hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			if (getFailureToDeliverApplicable()!=null) return true;
			if (getEEPParameters()!=null && getEEPParameters().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder o = (EnvironmentalPhysicalLeg.EnvironmentalPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getNumberOfAllowances(), o.getNumberOfAllowances(), this::setNumberOfAllowances);
			merger.mergeRosetta(getEnvironmental(), o.getEnvironmental(), this::setEnvironmental);
			merger.mergeRosetta(getDeliveryDate(), o.getDeliveryDate(), this::setDeliveryDate);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			merger.mergeRosetta(getEEPParameters(), o.getEEPParameters(), this::setEEPParameters);
			
			merger.mergeBasic(getAbandonmentOfScheme(), o.getAbandonmentOfScheme(), this::setAbandonmentOfScheme);
			merger.mergeBasic(getFailureToDeliverApplicable(), o.getFailureToDeliverApplicable(), this::setFailureToDeliverApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EnvironmentalPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(numberOfAllowances, _that.getNumberOfAllowances())) return false;
			if (!Objects.equals(environmental, _that.getEnvironmental())) return false;
			if (!Objects.equals(abandonmentOfScheme, _that.getAbandonmentOfScheme())) return false;
			if (!Objects.equals(deliveryDate, _that.getDeliveryDate())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(failureToDeliverApplicable, _that.getFailureToDeliverApplicable())) return false;
			if (!Objects.equals(eEPParameters, _that.getEEPParameters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (numberOfAllowances != null ? numberOfAllowances.hashCode() : 0);
			_result = 31 * _result + (environmental != null ? environmental.hashCode() : 0);
			_result = 31 * _result + (abandonmentOfScheme != null ? abandonmentOfScheme.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (failureToDeliverApplicable != null ? failureToDeliverApplicable.hashCode() : 0);
			_result = 31 * _result + (eEPParameters != null ? eEPParameters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalPhysicalLegBuilder {" +
				"numberOfAllowances=" + this.numberOfAllowances + ", " +
				"environmental=" + this.environmental + ", " +
				"abandonmentOfScheme=" + this.abandonmentOfScheme + ", " +
				"deliveryDate=" + this.deliveryDate + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"failureToDeliverApplicable=" + this.failureToDeliverApplicable + ", " +
				"eEPParameters=" + this.eEPParameters +
			'}' + " " + super.toString();
		}
	}
}
