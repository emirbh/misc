package fpml.consolidated.sec.lending;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.repo.DeliveryMethod;
import fpml.consolidated.sec.lending.meta.SecLendInitiationMeta;
import fpml.consolidated.shared.IdentifiedDate;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Initiation of the security lending transaction
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Initiation of the security lending transaction
 *
 */
@RosettaDataType(value="SecLendInitiation", builder=SecLendInitiation.SecLendInitiationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SecLendInitiation", model="fpml", builder=SecLendInitiation.SecLendInitiationBuilderImpl.class, version="2.1.1")
public interface SecLendInitiation extends SecLendTransferEvent {

	SecLendInitiationMeta metaData = new SecLendInitiationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Security transfer settlement date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Security transfer settlement date.
	 *
	 */
	IdentifiedDate getCollateralSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the rate which is applied to cash collateral when the cash collateral is settled ahead of the borrowed security. For example: at the initiation of the transaction, the borrow may post some cash right away, which gets returned overnight and substituted with securities, which would constitute as a collateral going forward. On T-0, you might actually hold some cash, pending the delivery of securities.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the rate which is applied to cash collateral when the cash collateral is settled ahead of the borrowed security. For example: at the initiation of the transaction, the borrow may post some cash right away, which gets returned overnight and substituted with securities, which would constitute as a collateral going forward. On T-0, you might actually hold some cash, pending the delivery of securities.
	 *
	 */
	PrepaidRate getPrepaidRate();

	/*********************** Build Methods  ***********************/
	SecLendInitiation build();
	
	SecLendInitiation.SecLendInitiationBuilder toBuilder();
	
	static SecLendInitiation.SecLendInitiationBuilder builder() {
		return new SecLendInitiation.SecLendInitiationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecLendInitiation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecLendInitiation> getType() {
		return SecLendInitiation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementDate"), processor, IdentifiedDate.class, getSettlementDate());
		processRosetta(path.newSubPath("deliveryMethod"), processor, DeliveryMethod.class, getDeliveryMethod());
		processRosetta(path.newSubPath("collateralSettlementDate"), processor, IdentifiedDate.class, getCollateralSettlementDate());
		processRosetta(path.newSubPath("prepaidRate"), processor, PrepaidRate.class, getPrepaidRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecLendInitiationBuilder extends SecLendInitiation, SecLendTransferEvent.SecLendTransferEventBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateCollateralSettlementDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getCollateralSettlementDate();
		PrepaidRate.PrepaidRateBuilder getOrCreatePrepaidRate();
		@Override
		PrepaidRate.PrepaidRateBuilder getPrepaidRate();
		@Override
		SecLendInitiation.SecLendInitiationBuilder setSettlementDate(IdentifiedDate settlementDate);
		@Override
		SecLendInitiation.SecLendInitiationBuilder setDeliveryMethod(DeliveryMethod deliveryMethod);
		SecLendInitiation.SecLendInitiationBuilder setCollateralSettlementDate(IdentifiedDate collateralSettlementDate);
		SecLendInitiation.SecLendInitiationBuilder setPrepaidRate(PrepaidRate prepaidRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("deliveryMethod"), processor, DeliveryMethod.DeliveryMethodBuilder.class, getDeliveryMethod());
			processRosetta(path.newSubPath("collateralSettlementDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getCollateralSettlementDate());
			processRosetta(path.newSubPath("prepaidRate"), processor, PrepaidRate.PrepaidRateBuilder.class, getPrepaidRate());
		}
		

		SecLendInitiation.SecLendInitiationBuilder prune();
	}

	/*********************** Immutable Implementation of SecLendInitiation  ***********************/
	class SecLendInitiationImpl extends SecLendTransferEvent.SecLendTransferEventImpl implements SecLendInitiation {
		private final IdentifiedDate collateralSettlementDate;
		private final PrepaidRate prepaidRate;
		
		protected SecLendInitiationImpl(SecLendInitiation.SecLendInitiationBuilder builder) {
			super(builder);
			this.collateralSettlementDate = ofNullable(builder.getCollateralSettlementDate()).map(f->f.build()).orElse(null);
			this.prepaidRate = ofNullable(builder.getPrepaidRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("collateralSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralSettlementDate")
		public IdentifiedDate getCollateralSettlementDate() {
			return collateralSettlementDate;
		}
		
		@Override
		@RosettaAttribute("prepaidRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prepaidRate")
		public PrepaidRate getPrepaidRate() {
			return prepaidRate;
		}
		
		@Override
		public SecLendInitiation build() {
			return this;
		}
		
		@Override
		public SecLendInitiation.SecLendInitiationBuilder toBuilder() {
			SecLendInitiation.SecLendInitiationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecLendInitiation.SecLendInitiationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCollateralSettlementDate()).ifPresent(builder::setCollateralSettlementDate);
			ofNullable(getPrepaidRate()).ifPresent(builder::setPrepaidRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SecLendInitiation _that = getType().cast(o);
		
			if (!Objects.equals(collateralSettlementDate, _that.getCollateralSettlementDate())) return false;
			if (!Objects.equals(prepaidRate, _that.getPrepaidRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (collateralSettlementDate != null ? collateralSettlementDate.hashCode() : 0);
			_result = 31 * _result + (prepaidRate != null ? prepaidRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecLendInitiation {" +
				"collateralSettlementDate=" + this.collateralSettlementDate + ", " +
				"prepaidRate=" + this.prepaidRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SecLendInitiation  ***********************/
	class SecLendInitiationBuilderImpl extends SecLendTransferEvent.SecLendTransferEventBuilderImpl implements SecLendInitiation.SecLendInitiationBuilder {
	
		protected IdentifiedDate.IdentifiedDateBuilder collateralSettlementDate;
		protected PrepaidRate.PrepaidRateBuilder prepaidRate;
		
		@Override
		@RosettaAttribute("collateralSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralSettlementDate")
		public IdentifiedDate.IdentifiedDateBuilder getCollateralSettlementDate() {
			return collateralSettlementDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateCollateralSettlementDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (collateralSettlementDate!=null) {
				result = collateralSettlementDate;
			}
			else {
				result = collateralSettlementDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("prepaidRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prepaidRate")
		public PrepaidRate.PrepaidRateBuilder getPrepaidRate() {
			return prepaidRate;
		}
		
		@Override
		public PrepaidRate.PrepaidRateBuilder getOrCreatePrepaidRate() {
			PrepaidRate.PrepaidRateBuilder result;
			if (prepaidRate!=null) {
				result = prepaidRate;
			}
			else {
				result = prepaidRate = PrepaidRate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementDate")
		@Override
		public SecLendInitiation.SecLendInitiationBuilder setSettlementDate(IdentifiedDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryMethod")
		@Override
		public SecLendInitiation.SecLendInitiationBuilder setDeliveryMethod(DeliveryMethod _deliveryMethod) {
			this.deliveryMethod = _deliveryMethod == null ? null : _deliveryMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralSettlementDate")
		@Override
		public SecLendInitiation.SecLendInitiationBuilder setCollateralSettlementDate(IdentifiedDate _collateralSettlementDate) {
			this.collateralSettlementDate = _collateralSettlementDate == null ? null : _collateralSettlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prepaidRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prepaidRate")
		@Override
		public SecLendInitiation.SecLendInitiationBuilder setPrepaidRate(PrepaidRate _prepaidRate) {
			this.prepaidRate = _prepaidRate == null ? null : _prepaidRate.toBuilder();
			return this;
		}
		
		@Override
		public SecLendInitiation build() {
			return new SecLendInitiation.SecLendInitiationImpl(this);
		}
		
		@Override
		public SecLendInitiation.SecLendInitiationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecLendInitiation.SecLendInitiationBuilder prune() {
			super.prune();
			if (collateralSettlementDate!=null && !collateralSettlementDate.prune().hasData()) collateralSettlementDate = null;
			if (prepaidRate!=null && !prepaidRate.prune().hasData()) prepaidRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCollateralSettlementDate()!=null && getCollateralSettlementDate().hasData()) return true;
			if (getPrepaidRate()!=null && getPrepaidRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecLendInitiation.SecLendInitiationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SecLendInitiation.SecLendInitiationBuilder o = (SecLendInitiation.SecLendInitiationBuilder) other;
			
			merger.mergeRosetta(getCollateralSettlementDate(), o.getCollateralSettlementDate(), this::setCollateralSettlementDate);
			merger.mergeRosetta(getPrepaidRate(), o.getPrepaidRate(), this::setPrepaidRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SecLendInitiation _that = getType().cast(o);
		
			if (!Objects.equals(collateralSettlementDate, _that.getCollateralSettlementDate())) return false;
			if (!Objects.equals(prepaidRate, _that.getPrepaidRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (collateralSettlementDate != null ? collateralSettlementDate.hashCode() : 0);
			_result = 31 * _result + (prepaidRate != null ? prepaidRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecLendInitiationBuilder {" +
				"collateralSettlementDate=" + this.collateralSettlementDate + ", " +
				"prepaidRate=" + this.prepaidRate +
			'}' + " " + super.toString();
		}
	}
}
