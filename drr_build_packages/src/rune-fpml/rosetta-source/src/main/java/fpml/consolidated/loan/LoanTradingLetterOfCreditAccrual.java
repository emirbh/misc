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
import fpml.consolidated.fpmlenum.LoanTradingLetterOfCreditFeeTypeEnum;
import fpml.consolidated.loan.meta.LoanTradingLetterOfCreditAccrualMeta;
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
 * Provision A structure that incorporates sub-periods of an accrual calculation for a traded letter of credit.
 *
 */
@RosettaDataType(value="LoanTradingLetterOfCreditAccrual", builder=LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradingLetterOfCreditAccrual", model="fpml", builder=LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilderImpl.class, version="2.1.1")
public interface LoanTradingLetterOfCreditAccrual extends AbstractTradingAccrual {

	LoanTradingLetterOfCreditAccrualMeta metaData = new LoanTradingLetterOfCreditAccrualMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique id associated with the letter of credit fee type.
	 *
	 */
	LcFeeTypeId getLcFeeTypeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the type of the letter of credit fee.
	 *
	 */
	LoanTradingLetterOfCreditFeeTypeEnum getLcFeeType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique identifier for the letter of credit.
	 *
	 */
	LetterOfCreditReference getLetterOfCreditReference();

	/*********************** Build Methods  ***********************/
	LoanTradingLetterOfCreditAccrual build();
	
	LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder toBuilder();
	
	static LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder builder() {
		return new LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingLetterOfCreditAccrual> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradingLetterOfCreditAccrual> getType() {
		return LoanTradingLetterOfCreditAccrual.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.class, getAccrualPeriod());
		processRosetta(path.newSubPath("lcFeeTypeId"), processor, LcFeeTypeId.class, getLcFeeTypeId());
		processor.processBasic(path.newSubPath("lcFeeType"), LoanTradingLetterOfCreditFeeTypeEnum.class, getLcFeeType(), this);
		processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.class, getLetterOfCreditReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingLetterOfCreditAccrualBuilder extends LoanTradingLetterOfCreditAccrual, AbstractTradingAccrual.AbstractTradingAccrualBuilder {
		LcFeeTypeId.LcFeeTypeIdBuilder getOrCreateLcFeeTypeId();
		@Override
		LcFeeTypeId.LcFeeTypeIdBuilder getLcFeeTypeId();
		LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference();
		@Override
		LetterOfCreditReference.LetterOfCreditReferenceBuilder getLetterOfCreditReference();
		@Override
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setAmount(Money amount);
		@Override
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod);
		@Override
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod, int idx);
		@Override
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod);
		@Override
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod);
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setLcFeeTypeId(LcFeeTypeId lcFeeTypeId);
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setLcFeeType(LoanTradingLetterOfCreditFeeTypeEnum lcFeeType);
		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualPeriod());
			processRosetta(path.newSubPath("lcFeeTypeId"), processor, LcFeeTypeId.LcFeeTypeIdBuilder.class, getLcFeeTypeId());
			processor.processBasic(path.newSubPath("lcFeeType"), LoanTradingLetterOfCreditFeeTypeEnum.class, getLcFeeType(), this);
			processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.LetterOfCreditReferenceBuilder.class, getLetterOfCreditReference());
		}
		

		LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingLetterOfCreditAccrual  ***********************/
	class LoanTradingLetterOfCreditAccrualImpl extends AbstractTradingAccrual.AbstractTradingAccrualImpl implements LoanTradingLetterOfCreditAccrual {
		private final LcFeeTypeId lcFeeTypeId;
		private final LoanTradingLetterOfCreditFeeTypeEnum lcFeeType;
		private final LetterOfCreditReference letterOfCreditReference;
		
		protected LoanTradingLetterOfCreditAccrualImpl(LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder builder) {
			super(builder);
			this.lcFeeTypeId = ofNullable(builder.getLcFeeTypeId()).map(f->f.build()).orElse(null);
			this.lcFeeType = builder.getLcFeeType();
			this.letterOfCreditReference = ofNullable(builder.getLetterOfCreditReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lcFeeTypeId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lcFeeTypeId")
		public LcFeeTypeId getLcFeeTypeId() {
			return lcFeeTypeId;
		}
		
		@Override
		@RosettaAttribute("lcFeeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcFeeType")
		public LoanTradingLetterOfCreditFeeTypeEnum getLcFeeType() {
			return lcFeeType;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("letterOfCreditReference")
		public LetterOfCreditReference getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		public LoanTradingLetterOfCreditAccrual build() {
			return this;
		}
		
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder toBuilder() {
			LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLcFeeTypeId()).ifPresent(builder::setLcFeeTypeId);
			ofNullable(getLcFeeType()).ifPresent(builder::setLcFeeType);
			ofNullable(getLetterOfCreditReference()).ifPresent(builder::setLetterOfCreditReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradingLetterOfCreditAccrual _that = getType().cast(o);
		
			if (!Objects.equals(lcFeeTypeId, _that.getLcFeeTypeId())) return false;
			if (!Objects.equals(lcFeeType, _that.getLcFeeType())) return false;
			if (!Objects.equals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcFeeTypeId != null ? lcFeeTypeId.hashCode() : 0);
			_result = 31 * _result + (lcFeeType != null ? lcFeeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingLetterOfCreditAccrual {" +
				"lcFeeTypeId=" + this.lcFeeTypeId + ", " +
				"lcFeeType=" + this.lcFeeType + ", " +
				"letterOfCreditReference=" + this.letterOfCreditReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradingLetterOfCreditAccrual  ***********************/
	class LoanTradingLetterOfCreditAccrualBuilderImpl extends AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl implements LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder {
	
		protected LcFeeTypeId.LcFeeTypeIdBuilder lcFeeTypeId;
		protected LoanTradingLetterOfCreditFeeTypeEnum lcFeeType;
		protected LetterOfCreditReference.LetterOfCreditReferenceBuilder letterOfCreditReference;
		
		@Override
		@RosettaAttribute("lcFeeTypeId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lcFeeTypeId")
		public LcFeeTypeId.LcFeeTypeIdBuilder getLcFeeTypeId() {
			return lcFeeTypeId;
		}
		
		@Override
		public LcFeeTypeId.LcFeeTypeIdBuilder getOrCreateLcFeeTypeId() {
			LcFeeTypeId.LcFeeTypeIdBuilder result;
			if (lcFeeTypeId!=null) {
				result = lcFeeTypeId;
			}
			else {
				result = lcFeeTypeId = LcFeeTypeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lcFeeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lcFeeType")
		public LoanTradingLetterOfCreditFeeTypeEnum getLcFeeType() {
			return lcFeeType;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("letterOfCreditReference")
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference() {
			LetterOfCreditReference.LetterOfCreditReferenceBuilder result;
			if (letterOfCreditReference!=null) {
				result = letterOfCreditReference;
			}
			else {
				result = letterOfCreditReference = LetterOfCreditReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setAmount(Money _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrualPeriod")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accrualPeriod")
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder addAccrualPeriod(AccrualPeriod _accrualPeriod) {
			if (_accrualPeriod != null) {
				this.accrualPeriod.add(_accrualPeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder addAccrualPeriod(AccrualPeriod _accrualPeriod, int idx) {
			getIndex(this.accrualPeriod, idx, () -> _accrualPeriod.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
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
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods == null) {
				this.accrualPeriod = new ArrayList<>();
			} else {
				this.accrualPeriod = accrualPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("lcFeeTypeId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("lcFeeTypeId")
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setLcFeeTypeId(LcFeeTypeId _lcFeeTypeId) {
			this.lcFeeTypeId = _lcFeeTypeId == null ? null : _lcFeeTypeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lcFeeType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lcFeeType")
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setLcFeeType(LoanTradingLetterOfCreditFeeTypeEnum _lcFeeType) {
			this.lcFeeType = _lcFeeType == null ? null : _lcFeeType;
			return this;
		}
		
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("letterOfCreditReference")
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder setLetterOfCreditReference(LetterOfCreditReference _letterOfCreditReference) {
			this.letterOfCreditReference = _letterOfCreditReference == null ? null : _letterOfCreditReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradingLetterOfCreditAccrual build() {
			return new LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualImpl(this);
		}
		
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder prune() {
			super.prune();
			if (lcFeeTypeId!=null && !lcFeeTypeId.prune().hasData()) lcFeeTypeId = null;
			if (letterOfCreditReference!=null && !letterOfCreditReference.prune().hasData()) letterOfCreditReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLcFeeTypeId()!=null && getLcFeeTypeId().hasData()) return true;
			if (getLcFeeType()!=null) return true;
			if (getLetterOfCreditReference()!=null && getLetterOfCreditReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder o = (LoanTradingLetterOfCreditAccrual.LoanTradingLetterOfCreditAccrualBuilder) other;
			
			merger.mergeRosetta(getLcFeeTypeId(), o.getLcFeeTypeId(), this::setLcFeeTypeId);
			merger.mergeRosetta(getLetterOfCreditReference(), o.getLetterOfCreditReference(), this::setLetterOfCreditReference);
			
			merger.mergeBasic(getLcFeeType(), o.getLcFeeType(), this::setLcFeeType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradingLetterOfCreditAccrual _that = getType().cast(o);
		
			if (!Objects.equals(lcFeeTypeId, _that.getLcFeeTypeId())) return false;
			if (!Objects.equals(lcFeeType, _that.getLcFeeType())) return false;
			if (!Objects.equals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcFeeTypeId != null ? lcFeeTypeId.hashCode() : 0);
			_result = 31 * _result + (lcFeeType != null ? lcFeeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingLetterOfCreditAccrualBuilder {" +
				"lcFeeTypeId=" + this.lcFeeTypeId + ", " +
				"lcFeeType=" + this.lcFeeType + ", " +
				"letterOfCreditReference=" + this.letterOfCreditReference +
			'}' + " " + super.toString();
		}
	}
}
