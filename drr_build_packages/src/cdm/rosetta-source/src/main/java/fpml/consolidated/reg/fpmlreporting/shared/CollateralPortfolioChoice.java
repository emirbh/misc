package fpml.consolidated.reg.fpmlreporting.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.reg.fpmlreporting.shared.meta.CollateralPortfolioChoiceMeta;
import fpml.consolidated.shared.PositiveMoney;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="CollateralPortfolioChoice", builder=CollateralPortfolioChoice.CollateralPortfolioChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CollateralPortfolioChoice", model="fpml", builder=CollateralPortfolioChoice.CollateralPortfolioChoiceBuilderImpl.class, version="2.1.1")
public interface CollateralPortfolioChoice extends RosettaModelObject {

	CollateralPortfolioChoiceMeta metaData = new CollateralPortfolioChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Represents the amount of cash posted as collateral. The cash collateral component is simple, just an instance of PositiveMoney type.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Represents the amount of cash posted as collateral. The cash collateral component is simple, just an instance of PositiveMoney type.
	 *
	 */
	PositiveMoney getCash();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Represents the type and the amount of security (non-cash) posted as collateral. The nonCash collateral component uses SecurityValuation.model to state what security it is, how much and the current dirty price. It also includes optional ability to specify the margin or haircut that applies to this piece of collateral.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Represents the type and the amount of security (non-cash) posted as collateral. The nonCash collateral component uses SecurityValuation.model to state what security it is, how much and the current dirty price. It also includes optional ability to specify the margin or haircut that applies to this piece of collateral.
	 *
	 */
	CollateralPosition getNonCash();

	/*********************** Build Methods  ***********************/
	CollateralPortfolioChoice build();
	
	CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder toBuilder();
	
	static CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder builder() {
		return new CollateralPortfolioChoice.CollateralPortfolioChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralPortfolioChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralPortfolioChoice> getType() {
		return CollateralPortfolioChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cash"), processor, PositiveMoney.class, getCash());
		processRosetta(path.newSubPath("nonCash"), processor, CollateralPosition.class, getNonCash());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralPortfolioChoiceBuilder extends CollateralPortfolioChoice, RosettaModelObjectBuilder {
		PositiveMoney.PositiveMoneyBuilder getOrCreateCash();
		@Override
		PositiveMoney.PositiveMoneyBuilder getCash();
		CollateralPosition.CollateralPositionBuilder getOrCreateNonCash();
		@Override
		CollateralPosition.CollateralPositionBuilder getNonCash();
		CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder setCash(PositiveMoney cash);
		CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder setNonCash(CollateralPosition nonCash);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cash"), processor, PositiveMoney.PositiveMoneyBuilder.class, getCash());
			processRosetta(path.newSubPath("nonCash"), processor, CollateralPosition.CollateralPositionBuilder.class, getNonCash());
		}
		

		CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralPortfolioChoice  ***********************/
	class CollateralPortfolioChoiceImpl implements CollateralPortfolioChoice {
		private final PositiveMoney cash;
		private final CollateralPosition nonCash;
		
		protected CollateralPortfolioChoiceImpl(CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder builder) {
			this.cash = ofNullable(builder.getCash()).map(f->f.build()).orElse(null);
			this.nonCash = ofNullable(builder.getNonCash()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cash")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cash")
		public PositiveMoney getCash() {
			return cash;
		}
		
		@Override
		@RosettaAttribute("nonCash")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonCash")
		public CollateralPosition getNonCash() {
			return nonCash;
		}
		
		@Override
		public CollateralPortfolioChoice build() {
			return this;
		}
		
		@Override
		public CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder toBuilder() {
			CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder builder) {
			ofNullable(getCash()).ifPresent(builder::setCash);
			ofNullable(getNonCash()).ifPresent(builder::setNonCash);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPortfolioChoice _that = getType().cast(o);
		
			if (!Objects.equals(cash, _that.getCash())) return false;
			if (!Objects.equals(nonCash, _that.getNonCash())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cash != null ? cash.hashCode() : 0);
			_result = 31 * _result + (nonCash != null ? nonCash.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPortfolioChoice {" +
				"cash=" + this.cash + ", " +
				"nonCash=" + this.nonCash +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralPortfolioChoice  ***********************/
	class CollateralPortfolioChoiceBuilderImpl implements CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder {
	
		protected PositiveMoney.PositiveMoneyBuilder cash;
		protected CollateralPosition.CollateralPositionBuilder nonCash;
		
		@Override
		@RosettaAttribute("cash")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cash")
		public PositiveMoney.PositiveMoneyBuilder getCash() {
			return cash;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateCash() {
			PositiveMoney.PositiveMoneyBuilder result;
			if (cash!=null) {
				result = cash;
			}
			else {
				result = cash = PositiveMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonCash")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonCash")
		public CollateralPosition.CollateralPositionBuilder getNonCash() {
			return nonCash;
		}
		
		@Override
		public CollateralPosition.CollateralPositionBuilder getOrCreateNonCash() {
			CollateralPosition.CollateralPositionBuilder result;
			if (nonCash!=null) {
				result = nonCash;
			}
			else {
				result = nonCash = CollateralPosition.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("cash")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cash")
		@Override
		public CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder setCash(PositiveMoney _cash) {
			this.cash = _cash == null ? null : _cash.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonCash")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonCash")
		@Override
		public CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder setNonCash(CollateralPosition _nonCash) {
			this.nonCash = _nonCash == null ? null : _nonCash.toBuilder();
			return this;
		}
		
		@Override
		public CollateralPortfolioChoice build() {
			return new CollateralPortfolioChoice.CollateralPortfolioChoiceImpl(this);
		}
		
		@Override
		public CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder prune() {
			if (cash!=null && !cash.prune().hasData()) cash = null;
			if (nonCash!=null && !nonCash.prune().hasData()) nonCash = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCash()!=null && getCash().hasData()) return true;
			if (getNonCash()!=null && getNonCash().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder o = (CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder) other;
			
			merger.mergeRosetta(getCash(), o.getCash(), this::setCash);
			merger.mergeRosetta(getNonCash(), o.getNonCash(), this::setNonCash);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPortfolioChoice _that = getType().cast(o);
		
			if (!Objects.equals(cash, _that.getCash())) return false;
			if (!Objects.equals(nonCash, _that.getNonCash())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cash != null ? cash.hashCode() : 0);
			_result = 31 * _result + (nonCash != null ? nonCash.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPortfolioChoiceBuilder {" +
				"cash=" + this.cash + ", " +
				"nonCash=" + this.nonCash +
			'}';
		}
	}
}
