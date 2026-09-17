package fpml.consolidated.loan;

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
import fpml.consolidated.fpmlenum.LoanTradingAccruingFeeTypeEnum;
import fpml.consolidated.loan.meta.LoanTradingFacilityFeeAccrualMeta;
import fpml.consolidated.shared.Money;
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
 * version "confirmation-5.13"
 *
 * Provision A structure that details the underlying elements that affect the calculation of a fee accrual.
 *
 */
@RosettaDataType(value="LoanTradingFacilityFeeAccrual", builder=LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradingFacilityFeeAccrual", model="fpml", builder=LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilderImpl.class, version="2.1.1")
public interface LoanTradingFacilityFeeAccrual extends AbstractTradingAccrual {

	LoanTradingFacilityFeeAccrualMeta metaData = new LoanTradingFacilityFeeAccrualMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique id associated with a facility accrual type.
	 *
	 */
	AccrualTypeId getAccruingFeeTypeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the type of the accruing fee.
	 *
	 */
	LoanTradingAccruingFeeTypeEnum getAccruingFeeType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	FacilityReference getFacilityReference();

	/*********************** Build Methods  ***********************/
	LoanTradingFacilityFeeAccrual build();
	
	LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder toBuilder();
	
	static LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder builder() {
		return new LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingFacilityFeeAccrual> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradingFacilityFeeAccrual> getType() {
		return LoanTradingFacilityFeeAccrual.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.class, getAccrualPeriod());
		processRosetta(path.newSubPath("accruingFeeTypeId"), processor, AccrualTypeId.class, getAccruingFeeTypeId());
		processor.processBasic(path.newSubPath("accruingFeeType"), LoanTradingAccruingFeeTypeEnum.class, getAccruingFeeType(), this);
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingFacilityFeeAccrualBuilder extends LoanTradingFacilityFeeAccrual, AbstractTradingAccrual.AbstractTradingAccrualBuilder {
		AccrualTypeId.AccrualTypeIdBuilder getOrCreateAccruingFeeTypeId();
		@Override
		AccrualTypeId.AccrualTypeIdBuilder getAccruingFeeTypeId();
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference();
		@Override
		FacilityReference.FacilityReferenceBuilder getFacilityReference();
		@Override
		LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder setAmount(Money amount);
		@Override
		LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod);
		@Override
		LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod, int idx);
		@Override
		LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod);
		@Override
		LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod);
		LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder setAccruingFeeTypeId(AccrualTypeId accruingFeeTypeId);
		LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder setAccruingFeeType(LoanTradingAccruingFeeTypeEnum accruingFeeType);
		LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder setFacilityReference(FacilityReference facilityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualPeriod());
			processRosetta(path.newSubPath("accruingFeeTypeId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccruingFeeTypeId());
			processor.processBasic(path.newSubPath("accruingFeeType"), LoanTradingAccruingFeeTypeEnum.class, getAccruingFeeType(), this);
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
		}
		

		LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingFacilityFeeAccrual  ***********************/
	class LoanTradingFacilityFeeAccrualImpl extends AbstractTradingAccrual.AbstractTradingAccrualImpl implements LoanTradingFacilityFeeAccrual {
		private final AccrualTypeId accruingFeeTypeId;
		private final LoanTradingAccruingFeeTypeEnum accruingFeeType;
		private final FacilityReference facilityReference;
		
		protected LoanTradingFacilityFeeAccrualImpl(LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder builder) {
			super(builder);
			this.accruingFeeTypeId = ofNullable(builder.getAccruingFeeTypeId()).map(f->f.build()).orElse(null);
			this.accruingFeeType = builder.getAccruingFeeType();
			this.facilityReference = ofNullable(builder.getFacilityReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accruingFeeTypeId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accruingFeeTypeId")
		public AccrualTypeId getAccruingFeeTypeId() {
			return accruingFeeTypeId;
		}
		
		@Override
		@RosettaAttribute("accruingFeeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruingFeeType")
		public LoanTradingAccruingFeeTypeEnum getAccruingFeeType() {
			return accruingFeeType;
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityReference")
		public FacilityReference getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public LoanTradingFacilityFeeAccrual build() {
			return this;
		}
		
		@Override
		public LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder toBuilder() {
			LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAccruingFeeTypeId()).ifPresent(builder::setAccruingFeeTypeId);
			ofNullable(getAccruingFeeType()).ifPresent(builder::setAccruingFeeType);
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradingFacilityFeeAccrual _that = getType().cast(o);
		
			if (!Objects.equals(accruingFeeTypeId, _that.getAccruingFeeTypeId())) return false;
			if (!Objects.equals(accruingFeeType, _that.getAccruingFeeType())) return false;
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingFeeTypeId != null ? accruingFeeTypeId.hashCode() : 0);
			_result = 31 * _result + (accruingFeeType != null ? accruingFeeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingFacilityFeeAccrual {" +
				"accruingFeeTypeId=" + this.accruingFeeTypeId + ", " +
				"accruingFeeType=" + this.accruingFeeType + ", " +
				"facilityReference=" + this.facilityReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradingFacilityFeeAccrual  ***********************/
	class LoanTradingFacilityFeeAccrualBuilderImpl extends AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl implements LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder {
	
		protected AccrualTypeId.AccrualTypeIdBuilder accruingFeeTypeId;
		protected LoanTradingAccruingFeeTypeEnum accruingFeeType;
		protected FacilityReference.FacilityReferenceBuilder facilityReference;
		
		@Override
		@RosettaAttribute("accruingFeeTypeId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("accruingFeeTypeId")
		public AccrualTypeId.AccrualTypeIdBuilder getAccruingFeeTypeId() {
			return accruingFeeTypeId;
		}
		
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder getOrCreateAccruingFeeTypeId() {
			AccrualTypeId.AccrualTypeIdBuilder result;
			if (accruingFeeTypeId!=null) {
				result = accruingFeeTypeId;
			}
			else {
				result = accruingFeeTypeId = AccrualTypeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accruingFeeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accruingFeeType")
		public LoanTradingAccruingFeeTypeEnum getAccruingFeeType() {
			return accruingFeeType;
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityReference")
		public FacilityReference.FacilityReferenceBuilder getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference() {
			FacilityReference.FacilityReferenceBuilder result;
			if (facilityReference!=null) {
				result = facilityReference;
			}
			else {
				result = facilityReference = FacilityReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder setAmount(Money _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrualPeriod")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accrualPeriod")
		@Override
		public LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder addAccrualPeriod(AccrualPeriod _accrualPeriod) {
			if (_accrualPeriod != null) {
				this.accrualPeriod.add(_accrualPeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder addAccrualPeriod(AccrualPeriod _accrualPeriod, int idx) {
			getIndex(this.accrualPeriod, idx, () -> _accrualPeriod.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods != null) {
				for (final AccrualPeriod toAdd : accrualPeriods) {
					this.accrualPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("accrualPeriod")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("accrualPeriod")
		@Override
		public LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods == null) {
				this.accrualPeriod = new ArrayList<>();
			} else {
				this.accrualPeriod = accrualPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("accruingFeeTypeId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("accruingFeeTypeId")
		@Override
		public LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder setAccruingFeeTypeId(AccrualTypeId _accruingFeeTypeId) {
			this.accruingFeeTypeId = _accruingFeeTypeId == null ? null : _accruingFeeTypeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accruingFeeType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accruingFeeType")
		@Override
		public LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder setAccruingFeeType(LoanTradingAccruingFeeTypeEnum _accruingFeeType) {
			this.accruingFeeType = _accruingFeeType == null ? null : _accruingFeeType;
			return this;
		}
		
		@RosettaAttribute("facilityReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityReference")
		@Override
		public LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder setFacilityReference(FacilityReference _facilityReference) {
			this.facilityReference = _facilityReference == null ? null : _facilityReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingFacilityFeeAccrual build() {
			return new LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualImpl(this);
		}
		
		@Override
		public LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder prune() {
			super.prune();
			if (accruingFeeTypeId!=null && !accruingFeeTypeId.prune().hasData()) accruingFeeTypeId = null;
			if (facilityReference!=null && !facilityReference.prune().hasData()) facilityReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAccruingFeeTypeId()!=null && getAccruingFeeTypeId().hasData()) return true;
			if (getAccruingFeeType()!=null) return true;
			if (getFacilityReference()!=null && getFacilityReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder o = (LoanTradingFacilityFeeAccrual.LoanTradingFacilityFeeAccrualBuilder) other;
			
			merger.mergeRosetta(getAccruingFeeTypeId(), o.getAccruingFeeTypeId(), this::setAccruingFeeTypeId);
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::setFacilityReference);
			
			merger.mergeBasic(getAccruingFeeType(), o.getAccruingFeeType(), this::setAccruingFeeType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradingFacilityFeeAccrual _that = getType().cast(o);
		
			if (!Objects.equals(accruingFeeTypeId, _that.getAccruingFeeTypeId())) return false;
			if (!Objects.equals(accruingFeeType, _that.getAccruingFeeType())) return false;
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingFeeTypeId != null ? accruingFeeTypeId.hashCode() : 0);
			_result = 31 * _result + (accruingFeeType != null ? accruingFeeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingFacilityFeeAccrualBuilder {" +
				"accruingFeeTypeId=" + this.accruingFeeTypeId + ", " +
				"accruingFeeType=" + this.accruingFeeType + ", " +
				"facilityReference=" + this.facilityReference +
			'}' + " " + super.toString();
		}
	}
}
