package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.FxTriggerBase;
import fpml.consolidated.fx.accruals.meta.FxAccrualTriggerMeta;
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
@RosettaDataType(value="FxAccrualTrigger", builder=FxAccrualTrigger.FxAccrualTriggerBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualTrigger", model="fpml", builder=FxAccrualTrigger.FxAccrualTriggerBuilderImpl.class, version="2.1.1")
public interface FxAccrualTrigger extends FxTriggerBase {

	FxAccrualTriggerMeta metaData = new FxAccrualTriggerMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An anchor to be referenced from the accrual region bound.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An anchor to be referenced from the accrual region bound.
	 *
	 */
	String getId();
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
	FxAccrualTrigger build();
	
	FxAccrualTrigger.FxAccrualTriggerBuilder toBuilder();
	
	static FxAccrualTrigger.FxAccrualTriggerBuilder builder() {
		return new FxAccrualTrigger.FxAccrualTriggerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualTrigger> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualTrigger> getType() {
		return FxAccrualTrigger.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
		processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.class, getQuotedCurrencyPair());
		processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
		processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("informationSource"), processor, InformationSource.class, getInformationSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualTriggerBuilder extends FxAccrualTrigger, FxTriggerBase.FxTriggerBaseBuilder {
		InformationSource.InformationSourceBuilder getOrCreateInformationSource(int index);
		@Override
		List<? extends InformationSource.InformationSourceBuilder> getInformationSource();
		@Override
		FxAccrualTrigger.FxAccrualTriggerBuilder setTriggerCondition(TriggerConditionEnum triggerCondition);
		@Override
		FxAccrualTrigger.FxAccrualTriggerBuilder setQuotedCurrencyPair(QuotedCurrencyPair quotedCurrencyPair);
		@Override
		FxAccrualTrigger.FxAccrualTriggerBuilder setTriggerRate(BigDecimal triggerRate);
		@Override
		FxAccrualTrigger.FxAccrualTriggerBuilder setSpotRate(BigDecimal spotRate);
		FxAccrualTrigger.FxAccrualTriggerBuilder setId(String id);
		FxAccrualTrigger.FxAccrualTriggerBuilder addInformationSource(InformationSource informationSource);
		FxAccrualTrigger.FxAccrualTriggerBuilder addInformationSource(InformationSource informationSource, int idx);
		FxAccrualTrigger.FxAccrualTriggerBuilder addInformationSource(List<? extends InformationSource> informationSource);
		FxAccrualTrigger.FxAccrualTriggerBuilder setInformationSource(List<? extends InformationSource> informationSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("triggerCondition"), TriggerConditionEnum.class, getTriggerCondition(), this);
			processRosetta(path.newSubPath("quotedCurrencyPair"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getQuotedCurrencyPair());
			processor.processBasic(path.newSubPath("triggerRate"), BigDecimal.class, getTriggerRate(), this);
			processor.processBasic(path.newSubPath("spotRate"), BigDecimal.class, getSpotRate(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("informationSource"), processor, InformationSource.InformationSourceBuilder.class, getInformationSource());
		}
		

		FxAccrualTrigger.FxAccrualTriggerBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualTrigger  ***********************/
	class FxAccrualTriggerImpl extends FxTriggerBase.FxTriggerBaseImpl implements FxAccrualTrigger {
		private final String id;
		private final List<? extends InformationSource> informationSource;
		
		protected FxAccrualTriggerImpl(FxAccrualTrigger.FxAccrualTriggerBuilder builder) {
			super(builder);
			this.id = builder.getId();
			this.informationSource = ofNullable(builder.getInformationSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
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
		public FxAccrualTrigger build() {
			return this;
		}
		
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder toBuilder() {
			FxAccrualTrigger.FxAccrualTriggerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualTrigger.FxAccrualTriggerBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getInformationSource()).ifPresent(builder::setInformationSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualTrigger _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualTrigger {" +
				"id=" + this.id + ", " +
				"informationSource=" + this.informationSource +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualTrigger  ***********************/
	class FxAccrualTriggerBuilderImpl extends FxTriggerBase.FxTriggerBaseBuilderImpl implements FxAccrualTrigger.FxAccrualTriggerBuilder {
	
		protected String id;
		protected List<InformationSource.InformationSourceBuilder> informationSource = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
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
		public FxAccrualTrigger.FxAccrualTriggerBuilder setTriggerCondition(TriggerConditionEnum _triggerCondition) {
			this.triggerCondition = _triggerCondition == null ? null : _triggerCondition;
			return this;
		}
		
		@RosettaAttribute("quotedCurrencyPair")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotedCurrencyPair")
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder setQuotedCurrencyPair(QuotedCurrencyPair _quotedCurrencyPair) {
			this.quotedCurrencyPair = _quotedCurrencyPair == null ? null : _quotedCurrencyPair.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerRate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("triggerRate")
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder setTriggerRate(BigDecimal _triggerRate) {
			this.triggerRate = _triggerRate == null ? null : _triggerRate;
			return this;
		}
		
		@RosettaAttribute("spotRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotRate")
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder setSpotRate(BigDecimal _spotRate) {
			this.spotRate = _spotRate == null ? null : _spotRate;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("informationSource")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("informationSource")
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder addInformationSource(InformationSource _informationSource) {
			if (_informationSource != null) {
				this.informationSource.add(_informationSource.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder addInformationSource(InformationSource _informationSource, int idx) {
			getIndex(this.informationSource, idx, () -> _informationSource.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder addInformationSource(List<? extends InformationSource> informationSources) {
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
		public FxAccrualTrigger.FxAccrualTriggerBuilder setInformationSource(List<? extends InformationSource> informationSources) {
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
		public FxAccrualTrigger build() {
			return new FxAccrualTrigger.FxAccrualTriggerImpl(this);
		}
		
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder prune() {
			super.prune();
			informationSource = informationSource.stream().filter(b->b!=null).<InformationSource.InformationSourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getId()!=null) return true;
			if (getInformationSource()!=null && getInformationSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualTrigger.FxAccrualTriggerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxAccrualTrigger.FxAccrualTriggerBuilder o = (FxAccrualTrigger.FxAccrualTriggerBuilder) other;
			
			merger.mergeRosetta(getInformationSource(), o.getInformationSource(), this::getOrCreateInformationSource);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualTrigger _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(informationSource, _that.getInformationSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (informationSource != null ? informationSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualTriggerBuilder {" +
				"id=" + this.id + ", " +
				"informationSource=" + this.informationSource +
			'}' + " " + super.toString();
		}
	}
}
