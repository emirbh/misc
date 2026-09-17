package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.StrikeScheduleMeta;
import java.math.BigDecimal;
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
 * Provision A type describing a schedule of cap or floor rates.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing a schedule of cap or floor rates.
 *
 */
@RosettaDataType(value="StrikeSchedule", builder=StrikeSchedule.StrikeScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="StrikeSchedule", model="fpml", builder=StrikeSchedule.StrikeScheduleBuilderImpl.class, version="2.1.1")
public interface StrikeSchedule extends Schedule {

	StrikeScheduleMeta metaData = new StrikeScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The buyer of the option
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The buyer of the option
	 *
	 */
	IdentifiedPayerReceiver getBuyer();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The party that has sold.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party that has sold.
	 *
	 */
	IdentifiedPayerReceiver getSeller();

	/*********************** Build Methods  ***********************/
	StrikeSchedule build();
	
	StrikeSchedule.StrikeScheduleBuilder toBuilder();
	
	static StrikeSchedule.StrikeScheduleBuilder builder() {
		return new StrikeSchedule.StrikeScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StrikeSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends StrikeSchedule> getType() {
		return StrikeSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
		processRosetta(path.newSubPath("step"), processor, Step.class, getStep());
		processRosetta(path.newSubPath("buyer"), processor, IdentifiedPayerReceiver.class, getBuyer());
		processRosetta(path.newSubPath("seller"), processor, IdentifiedPayerReceiver.class, getSeller());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StrikeScheduleBuilder extends StrikeSchedule, Schedule.ScheduleBuilder {
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateBuyer();
		@Override
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getBuyer();
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateSeller();
		@Override
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getSeller();
		@Override
		StrikeSchedule.StrikeScheduleBuilder setId(String id);
		@Override
		StrikeSchedule.StrikeScheduleBuilder setInitialValue(BigDecimal initialValue);
		@Override
		StrikeSchedule.StrikeScheduleBuilder addStep(Step step);
		@Override
		StrikeSchedule.StrikeScheduleBuilder addStep(Step step, int idx);
		@Override
		StrikeSchedule.StrikeScheduleBuilder addStep(List<? extends Step> step);
		@Override
		StrikeSchedule.StrikeScheduleBuilder setStep(List<? extends Step> step);
		StrikeSchedule.StrikeScheduleBuilder setBuyer(IdentifiedPayerReceiver buyer);
		StrikeSchedule.StrikeScheduleBuilder setSeller(IdentifiedPayerReceiver seller);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("initialValue"), BigDecimal.class, getInitialValue(), this);
			processRosetta(path.newSubPath("step"), processor, Step.StepBuilder.class, getStep());
			processRosetta(path.newSubPath("buyer"), processor, IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder.class, getBuyer());
			processRosetta(path.newSubPath("seller"), processor, IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder.class, getSeller());
		}
		

		StrikeSchedule.StrikeScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of StrikeSchedule  ***********************/
	class StrikeScheduleImpl extends Schedule.ScheduleImpl implements StrikeSchedule {
		private final IdentifiedPayerReceiver buyer;
		private final IdentifiedPayerReceiver seller;
		
		protected StrikeScheduleImpl(StrikeSchedule.StrikeScheduleBuilder builder) {
			super(builder);
			this.buyer = ofNullable(builder.getBuyer()).map(f->f.build()).orElse(null);
			this.seller = ofNullable(builder.getSeller()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyer")
		public IdentifiedPayerReceiver getBuyer() {
			return buyer;
		}
		
		@Override
		@RosettaAttribute("seller")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seller")
		public IdentifiedPayerReceiver getSeller() {
			return seller;
		}
		
		@Override
		public StrikeSchedule build() {
			return this;
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder toBuilder() {
			StrikeSchedule.StrikeScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StrikeSchedule.StrikeScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyer()).ifPresent(builder::setBuyer);
			ofNullable(getSeller()).ifPresent(builder::setSeller);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StrikeSchedule _that = getType().cast(o);
		
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyer != null ? buyer.hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrikeSchedule {" +
				"buyer=" + this.buyer + ", " +
				"seller=" + this.seller +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of StrikeSchedule  ***********************/
	class StrikeScheduleBuilderImpl extends Schedule.ScheduleBuilderImpl implements StrikeSchedule.StrikeScheduleBuilder {
	
		protected IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder buyer;
		protected IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder seller;
		
		@Override
		@RosettaAttribute("buyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyer")
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getBuyer() {
			return buyer;
		}
		
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateBuyer() {
			IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder result;
			if (buyer!=null) {
				result = buyer;
			}
			else {
				result = buyer = IdentifiedPayerReceiver.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("seller")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seller")
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getSeller() {
			return seller;
		}
		
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder getOrCreateSeller() {
			IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder result;
			if (seller!=null) {
				result = seller;
			}
			else {
				result = seller = IdentifiedPayerReceiver.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public StrikeSchedule.StrikeScheduleBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("initialValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("initialValue")
		@Override
		public StrikeSchedule.StrikeScheduleBuilder setInitialValue(BigDecimal _initialValue) {
			this.initialValue = _initialValue == null ? null : _initialValue;
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("step")
		@Override
		public StrikeSchedule.StrikeScheduleBuilder addStep(Step _step) {
			if (_step != null) {
				this.step.add(_step.toBuilder());
			}
			return this;
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder addStep(Step _step, int idx) {
			getIndex(this.step, idx, () -> _step.toBuilder());
			return this;
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder addStep(List<? extends Step> steps) {
			if (steps != null) {
				for (final Step toAdd : steps) {
					this.step.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("step")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("step")
		@Override
		public StrikeSchedule.StrikeScheduleBuilder setStep(List<? extends Step> steps) {
			if (steps == null) {
				this.step = new ArrayList<>();
			} else {
				this.step = steps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("buyer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyer")
		@Override
		public StrikeSchedule.StrikeScheduleBuilder setBuyer(IdentifiedPayerReceiver _buyer) {
			this.buyer = _buyer == null ? null : _buyer.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seller")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seller")
		@Override
		public StrikeSchedule.StrikeScheduleBuilder setSeller(IdentifiedPayerReceiver _seller) {
			this.seller = _seller == null ? null : _seller.toBuilder();
			return this;
		}
		
		@Override
		public StrikeSchedule build() {
			return new StrikeSchedule.StrikeScheduleImpl(this);
		}
		
		@Override
		public StrikeSchedule.StrikeScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrikeSchedule.StrikeScheduleBuilder prune() {
			super.prune();
			if (buyer!=null && !buyer.prune().hasData()) buyer = null;
			if (seller!=null && !seller.prune().hasData()) seller = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyer()!=null && getBuyer().hasData()) return true;
			if (getSeller()!=null && getSeller().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StrikeSchedule.StrikeScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			StrikeSchedule.StrikeScheduleBuilder o = (StrikeSchedule.StrikeScheduleBuilder) other;
			
			merger.mergeRosetta(getBuyer(), o.getBuyer(), this::setBuyer);
			merger.mergeRosetta(getSeller(), o.getSeller(), this::setSeller);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			StrikeSchedule _that = getType().cast(o);
		
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyer != null ? buyer.hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StrikeScheduleBuilder {" +
				"buyer=" + this.buyer + ", " +
				"seller=" + this.seller +
			'}' + " " + super.toString();
		}
	}
}
