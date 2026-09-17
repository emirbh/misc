package fpml.consolidated.fx;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.fpmlenum.TriggerConditionEnum;
import fpml.consolidated.fx.meta.FxTriggerMeta;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
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
 * Provision Describes a european trigger applied to an FX digtal option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes a european trigger applied to an FX digtal option.
 *
 */
@RosettaDataType(value="FxTrigger", builder=FxTrigger.FxTriggerBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTrigger", model="fpml", builder=FxTrigger.FxTriggerBuilderImpl.class, version="2.1.1")
public interface FxTrigger extends FxTriggerBase {

	FxTriggerMeta metaData = new FxTriggerMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
	 *
	 */
	List<? extends InformationSource> getInformationSource();

	/*********************** Build Methods  ***********************/
	FxTrigger build();
	
	FxTrigger.FxTriggerBuilder toBuilder();
	
	static FxTrigger.FxTriggerBuilder builder() {
		return new FxTrigger.FxTriggerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTrigger> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTrigger> getType() {
		return FxTrigger.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTriggerBuilder extends FxTrigger, FxTriggerBase.FxTriggerBaseBuilder {
		InformationSource.InformationSourceBuilder getOrCreateInformationSource(int index);
		@Override
		List<? extends InformationSource.InformationSourceBuilder> getInformationSource();
		@Override
		FxTrigger.FxTriggerBuilder setTriggerCondition(TriggerConditionEnum triggerCondition);
		@Override
		FxTrigger.FxTriggerBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		@Override
		FxTrigger.FxTriggerBuilder setTriggerRate(BigDecimal triggerRate);
		@Override
		FxTrigger.FxTriggerBuilder setSpotRate(BigDecimal spotRate);
		FxTrigger.FxTriggerBuilder addInformationSource(InformationSource informationSource);
		FxTrigger.FxTriggerBuilder addInformationSource(InformationSource informationSource, int idx);
		FxTrigger.FxTriggerBuilder addInformationSource(List<? extends InformationSource> informationSource);
		FxTrigger.FxTriggerBuilder setInformationSource(List<? extends InformationSource> informationSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
		}
		

		FxTrigger.FxTriggerBuilder prune();
	}

	/*********************** Immutable Implementation of FxTrigger  ***********************/
	class FxTriggerImpl extends FxTriggerBase.FxTriggerBaseImpl implements FxTrigger {
		private final List<? extends InformationSource> informationSource;
		
		protected FxTriggerImpl(FxTrigger.FxTriggerBuilder builder) {
			super(builder);
			this.informationSource = ofNullable(builder.getInformationSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("informationSource")
		public List<? extends InformationSource> getInformationSource() {
			return informationSource;
		}
		
		@Override
		public FxTrigger build() {
			return this;
		}
		
		@Override
		public FxTrigger.FxTriggerBuilder toBuilder() {
			FxTrigger.FxTriggerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTrigger.FxTriggerBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTrigger _that = getType().cast(o);
		
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTrigger {" +
				"informationSource=" + this.informationSource +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTrigger  ***********************/
	class FxTriggerBuilderImpl extends FxTriggerBase.FxTriggerBaseBuilderImpl implements FxTrigger.FxTriggerBuilder {
	
		protected List<InformationSource.InformationSourceBuilder> informationSource = new ArrayList<>();
		
		@Override
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("informationSource")
		public List<? extends InformationSource.InformationSourceBuilder> getInformationSource() {
			return informationSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateInformationSource(int index) {
			if (informationSource==null) {
				this.informationSource = new ArrayList<>();
			}
			return getIndex(informationSource, index, () -> {
						InformationSource.InformationSourceBuilder newInformationSource = InformationSource.builder();
						return newInformationSource;
					});
		}
		
		@RosettaAttribute("triggerCondition")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("triggerCondition")
		@Override
		public FxTrigger.FxTriggerBuilder setTriggerCondition(TriggerConditionEnum _triggerCondition) {
			this.triggerCondition = _triggerCondition == null ? null : _triggerCondition;
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxTrigger.FxTriggerBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("triggerRate")
		@Override
		public FxTrigger.FxTriggerBuilder setTriggerRate(BigDecimal _triggerRate) {
			this.triggerRate = _triggerRate == null ? null : _triggerRate;
			return this;
		}
		
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotRate")
		@Override
		public FxTrigger.FxTriggerBuilder setSpotRate(BigDecimal _spotRate) {
			this.spotRate = _spotRate == null ? null : _spotRate;
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("informationSource")
		@Override
		public FxTrigger.FxTriggerBuilder addInformationSource(InformationSource _informationSource) {
			if (_informationSource != null) {
				this.informationSource.add(_informationSource.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTrigger.FxTriggerBuilder addInformationSource(InformationSource _informationSource, int idx) {
			getIndex(this.informationSource, idx, () -> _informationSource.toBuilder());
			return this;
		}
		
		@Override
		public FxTrigger.FxTriggerBuilder addInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources != null) {
				for (final InformationSource toAdd : informationSources) {
					this.informationSource.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("informationSource")
		@Override
		public FxTrigger.FxTriggerBuilder setInformationSource(List<? extends InformationSource> informationSources) {
			if (informationSources == null) {
				this.informationSource = new ArrayList<>();
			} else {
				this.informationSource = informationSources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxTrigger build() {
			return new FxTrigger.FxTriggerImpl(this);
		}
		
		@Override
		public FxTrigger.FxTriggerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTrigger.FxTriggerBuilder prune() {
			super.prune();
			informationSource = informationSource.stream().filter(b->b!=null).<InformationSource.InformationSourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInformationSource()!=null && getInformationSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTrigger.FxTriggerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxTrigger.FxTriggerBuilder o = (FxTrigger.FxTriggerBuilder) other;
			
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::getOrCreateInformationSource);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTrigger _that = getType().cast(o);
		
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTriggerBuilder {" +
				"informationSource=" + this.informationSource +
			'}' + " " + super.toString();
		}
	}
}
