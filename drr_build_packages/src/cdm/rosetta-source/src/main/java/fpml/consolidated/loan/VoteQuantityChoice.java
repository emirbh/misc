package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.VoteQuantityChoiceMeta;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="VoteQuantityChoice", builder=VoteQuantityChoice.VoteQuantityChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VoteQuantityChoice", model="fpml", builder=VoteQuantityChoice.VoteQuantityChoiceBuilderImpl.class, version="2.1.1")
public interface VoteQuantityChoice extends RosettaModelObject {

	VoteQuantityChoiceMeta metaData = new VoteQuantityChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe a vote quantity as a number (non-negative integer) of votes.
	 *
	 */
	Integer getVoteCount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe a vote quantity as a percent to total votes possible.
	 *
	 */
	BigDecimal getVotePercent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional structure to describe a vote quantity as an amount in a currency (e.g. in the loan market, as a lender's commitment amount).
	 *
	 */
	NonNegativeMoney getVoteAmount();

	/*********************** Build Methods  ***********************/
	VoteQuantityChoice build();
	
	VoteQuantityChoice.VoteQuantityChoiceBuilder toBuilder();
	
	static VoteQuantityChoice.VoteQuantityChoiceBuilder builder() {
		return new VoteQuantityChoice.VoteQuantityChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VoteQuantityChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VoteQuantityChoice> getType() {
		return VoteQuantityChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("voteCount"), Integer.class, getVoteCount(), this);
		processor.processBasic(path.newSubPath("votePercent"), BigDecimal.class, getVotePercent(), this);
		processRosetta(path.newSubPath("voteAmount"), processor, NonNegativeMoney.class, getVoteAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VoteQuantityChoiceBuilder extends VoteQuantityChoice, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateVoteAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getVoteAmount();
		VoteQuantityChoice.VoteQuantityChoiceBuilder setVoteCount(Integer voteCount);
		VoteQuantityChoice.VoteQuantityChoiceBuilder setVotePercent(BigDecimal votePercent);
		VoteQuantityChoice.VoteQuantityChoiceBuilder setVoteAmount(NonNegativeMoney voteAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("voteCount"), Integer.class, getVoteCount(), this);
			processor.processBasic(path.newSubPath("votePercent"), BigDecimal.class, getVotePercent(), this);
			processRosetta(path.newSubPath("voteAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getVoteAmount());
		}
		

		VoteQuantityChoice.VoteQuantityChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of VoteQuantityChoice  ***********************/
	class VoteQuantityChoiceImpl implements VoteQuantityChoice {
		private final Integer voteCount;
		private final BigDecimal votePercent;
		private final NonNegativeMoney voteAmount;
		
		protected VoteQuantityChoiceImpl(VoteQuantityChoice.VoteQuantityChoiceBuilder builder) {
			this.voteCount = builder.getVoteCount();
			this.votePercent = builder.getVotePercent();
			this.voteAmount = ofNullable(builder.getVoteAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("voteCount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("voteCount")
		public Integer getVoteCount() {
			return voteCount;
		}
		
		@Override
		@RosettaAttribute("votePercent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("votePercent")
		public BigDecimal getVotePercent() {
			return votePercent;
		}
		
		@Override
		@RosettaAttribute("voteAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("voteAmount")
		public NonNegativeMoney getVoteAmount() {
			return voteAmount;
		}
		
		@Override
		public VoteQuantityChoice build() {
			return this;
		}
		
		@Override
		public VoteQuantityChoice.VoteQuantityChoiceBuilder toBuilder() {
			VoteQuantityChoice.VoteQuantityChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VoteQuantityChoice.VoteQuantityChoiceBuilder builder) {
			ofNullable(getVoteCount()).ifPresent(builder::setVoteCount);
			ofNullable(getVotePercent()).ifPresent(builder::setVotePercent);
			ofNullable(getVoteAmount()).ifPresent(builder::setVoteAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VoteQuantityChoice _that = getType().cast(o);
		
			if (!Objects.equals(voteCount, _that.getVoteCount())) return false;
			if (!Objects.equals(votePercent, _that.getVotePercent())) return false;
			if (!Objects.equals(voteAmount, _that.getVoteAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (voteCount != null ? voteCount.hashCode() : 0);
			_result = 31 * _result + (votePercent != null ? votePercent.hashCode() : 0);
			_result = 31 * _result + (voteAmount != null ? voteAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VoteQuantityChoice {" +
				"voteCount=" + this.voteCount + ", " +
				"votePercent=" + this.votePercent + ", " +
				"voteAmount=" + this.voteAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of VoteQuantityChoice  ***********************/
	class VoteQuantityChoiceBuilderImpl implements VoteQuantityChoice.VoteQuantityChoiceBuilder {
	
		protected Integer voteCount;
		protected BigDecimal votePercent;
		protected NonNegativeMoney.NonNegativeMoneyBuilder voteAmount;
		
		@Override
		@RosettaAttribute("voteCount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("voteCount")
		public Integer getVoteCount() {
			return voteCount;
		}
		
		@Override
		@RosettaAttribute("votePercent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("votePercent")
		public BigDecimal getVotePercent() {
			return votePercent;
		}
		
		@Override
		@RosettaAttribute("voteAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("voteAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getVoteAmount() {
			return voteAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateVoteAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (voteAmount!=null) {
				result = voteAmount;
			}
			else {
				result = voteAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("voteCount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("voteCount")
		@Override
		public VoteQuantityChoice.VoteQuantityChoiceBuilder setVoteCount(Integer _voteCount) {
			this.voteCount = _voteCount == null ? null : _voteCount;
			return this;
		}
		
		@RosettaAttribute("votePercent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("votePercent")
		@Override
		public VoteQuantityChoice.VoteQuantityChoiceBuilder setVotePercent(BigDecimal _votePercent) {
			this.votePercent = _votePercent == null ? null : _votePercent;
			return this;
		}
		
		@RosettaAttribute("voteAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("voteAmount")
		@Override
		public VoteQuantityChoice.VoteQuantityChoiceBuilder setVoteAmount(NonNegativeMoney _voteAmount) {
			this.voteAmount = _voteAmount == null ? null : _voteAmount.toBuilder();
			return this;
		}
		
		@Override
		public VoteQuantityChoice build() {
			return new VoteQuantityChoice.VoteQuantityChoiceImpl(this);
		}
		
		@Override
		public VoteQuantityChoice.VoteQuantityChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VoteQuantityChoice.VoteQuantityChoiceBuilder prune() {
			if (voteAmount!=null && !voteAmount.prune().hasData()) voteAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getVoteCount()!=null) return true;
			if (getVotePercent()!=null) return true;
			if (getVoteAmount()!=null && getVoteAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VoteQuantityChoice.VoteQuantityChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			VoteQuantityChoice.VoteQuantityChoiceBuilder o = (VoteQuantityChoice.VoteQuantityChoiceBuilder) other;
			
			merger.mergeRosetta(getVoteAmount(), o.getVoteAmount(), this::setVoteAmount);
			
			merger.mergeBasic(getVoteCount(), o.getVoteCount(), this::setVoteCount);
			merger.mergeBasic(getVotePercent(), o.getVotePercent(), this::setVotePercent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			VoteQuantityChoice _that = getType().cast(o);
		
			if (!Objects.equals(voteCount, _that.getVoteCount())) return false;
			if (!Objects.equals(votePercent, _that.getVotePercent())) return false;
			if (!Objects.equals(voteAmount, _that.getVoteAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (voteCount != null ? voteCount.hashCode() : 0);
			_result = 31 * _result + (votePercent != null ? votePercent.hashCode() : 0);
			_result = 31 * _result + (voteAmount != null ? voteAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VoteQuantityChoiceBuilder {" +
				"voteCount=" + this.voteCount + ", " +
				"votePercent=" + this.votePercent + ", " +
				"voteAmount=" + this.voteAmount +
			'}';
		}
	}
}
