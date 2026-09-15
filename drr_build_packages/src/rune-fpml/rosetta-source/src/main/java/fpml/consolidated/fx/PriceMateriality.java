package fpml.consolidated.fx;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.fx.meta.PriceMaterialityMeta;
import fpml.consolidated.shared.SettlementRateOption;
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
 * Provision A structure describing the criteria for price materiality.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure describing the criteria for price materiality.
 *
 */
@RosettaDataType(value="PriceMateriality", builder=PriceMateriality.PriceMaterialityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PriceMateriality", model="fpml", builder=PriceMateriality.PriceMaterialityBuilderImpl.class, version="2.1.1")
public interface PriceMateriality extends FxDisruptionEvent {

	PriceMaterialityMeta metaData = new PriceMaterialityMeta();

	/*********************** Getter Methods  ***********************/
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
	SettlementRateOption getPrimaryRateSource();
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
	List<? extends SettlementRateOption> getSecondaryRateSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A value expressed in percentage units i.e. 5 means 5%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A value expressed in percentage units i.e. 5 means 5%.
	 *
	 */
	BigDecimal getPercentage();

	/*********************** Build Methods  ***********************/
	PriceMateriality build();
	
	PriceMateriality.PriceMaterialityBuilder toBuilder();
	
	static PriceMateriality.PriceMaterialityBuilder builder() {
		return new PriceMateriality.PriceMaterialityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PriceMateriality> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PriceMateriality> getType() {
		return PriceMateriality.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("primaryRateSource"), processor, SettlementRateOption.class, getPrimaryRateSource());
		processRosetta(path.newSubPath("secondaryRateSource"), processor, SettlementRateOption.class, getSecondaryRateSource());
		processor.processBasic(path.newSubPath("percentage"), BigDecimal.class, getPercentage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceMaterialityBuilder extends PriceMateriality, FxDisruptionEvent.FxDisruptionEventBuilder {
		SettlementRateOption.SettlementRateOptionBuilder getOrCreatePrimaryRateSource();
		@Override
		SettlementRateOption.SettlementRateOptionBuilder getPrimaryRateSource();
		SettlementRateOption.SettlementRateOptionBuilder getOrCreateSecondaryRateSource(int index);
		@Override
		List<? extends SettlementRateOption.SettlementRateOptionBuilder> getSecondaryRateSource();
		PriceMateriality.PriceMaterialityBuilder setPrimaryRateSource(SettlementRateOption primaryRateSource);
		PriceMateriality.PriceMaterialityBuilder addSecondaryRateSource(SettlementRateOption secondaryRateSource);
		PriceMateriality.PriceMaterialityBuilder addSecondaryRateSource(SettlementRateOption secondaryRateSource, int idx);
		PriceMateriality.PriceMaterialityBuilder addSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSource);
		PriceMateriality.PriceMaterialityBuilder setSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSource);
		PriceMateriality.PriceMaterialityBuilder setPercentage(BigDecimal percentage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("primaryRateSource"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getPrimaryRateSource());
			processRosetta(path.newSubPath("secondaryRateSource"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getSecondaryRateSource());
			processor.processBasic(path.newSubPath("percentage"), BigDecimal.class, getPercentage(), this);
		}
		

		PriceMateriality.PriceMaterialityBuilder prune();
	}

	/*********************** Immutable Implementation of PriceMateriality  ***********************/
	class PriceMaterialityImpl extends FxDisruptionEvent.FxDisruptionEventImpl implements PriceMateriality {
		private final SettlementRateOption primaryRateSource;
		private final List<? extends SettlementRateOption> secondaryRateSource;
		private final BigDecimal percentage;
		
		protected PriceMaterialityImpl(PriceMateriality.PriceMaterialityBuilder builder) {
			super(builder);
			this.primaryRateSource = ofNullable(builder.getPrimaryRateSource()).map(f->f.build()).orElse(null);
			this.secondaryRateSource = ofNullable(builder.getSecondaryRateSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.percentage = builder.getPercentage();
		}
		
		@Override
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryRateSource")
		public SettlementRateOption getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("secondaryRateSource")
		public List<? extends SettlementRateOption> getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		@RosettaAttribute("percentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("percentage")
		public BigDecimal getPercentage() {
			return percentage;
		}
		
		@Override
		public PriceMateriality build() {
			return this;
		}
		
		@Override
		public PriceMateriality.PriceMaterialityBuilder toBuilder() {
			PriceMateriality.PriceMaterialityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceMateriality.PriceMaterialityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPrimaryRateSource()).ifPresent(builder::setPrimaryRateSource);
			ofNullable(getSecondaryRateSource()).ifPresent(builder::setSecondaryRateSource);
			ofNullable(getPercentage()).ifPresent(builder::setPercentage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PriceMateriality _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!ListEquals.listEquals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(percentage, _that.getPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (percentage != null ? percentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceMateriality {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"percentage=" + this.percentage +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PriceMateriality  ***********************/
	class PriceMaterialityBuilderImpl extends FxDisruptionEvent.FxDisruptionEventBuilderImpl implements PriceMateriality.PriceMaterialityBuilder {
	
		protected SettlementRateOption.SettlementRateOptionBuilder primaryRateSource;
		protected List<SettlementRateOption.SettlementRateOptionBuilder> secondaryRateSource = new ArrayList<>();
		protected BigDecimal percentage;
		
		@Override
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("primaryRateSource")
		public SettlementRateOption.SettlementRateOptionBuilder getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder getOrCreatePrimaryRateSource() {
			SettlementRateOption.SettlementRateOptionBuilder result;
			if (primaryRateSource!=null) {
				result = primaryRateSource;
			}
			else {
				result = primaryRateSource = SettlementRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("secondaryRateSource")
		public List<? extends SettlementRateOption.SettlementRateOptionBuilder> getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder getOrCreateSecondaryRateSource(int index) {
			if (secondaryRateSource==null) {
				this.secondaryRateSource = new ArrayList<>();
			}
			return getIndex(secondaryRateSource, index, () -> {
						SettlementRateOption.SettlementRateOptionBuilder newSecondaryRateSource = SettlementRateOption.builder();
						return newSecondaryRateSource;
					});
		}
		
		@Override
		@RosettaAttribute("percentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("percentage")
		public BigDecimal getPercentage() {
			return percentage;
		}
		
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryRateSource")
		@Override
		public PriceMateriality.PriceMaterialityBuilder setPrimaryRateSource(SettlementRateOption _primaryRateSource) {
			this.primaryRateSource = _primaryRateSource == null ? null : _primaryRateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryRateSource")
		@Override
		public PriceMateriality.PriceMaterialityBuilder addSecondaryRateSource(SettlementRateOption _secondaryRateSource) {
			if (_secondaryRateSource != null) {
				this.secondaryRateSource.add(_secondaryRateSource.toBuilder());
			}
			return this;
		}
		
		@Override
		public PriceMateriality.PriceMaterialityBuilder addSecondaryRateSource(SettlementRateOption _secondaryRateSource, int idx) {
			getIndex(this.secondaryRateSource, idx, () -> _secondaryRateSource.toBuilder());
			return this;
		}
		
		@Override
		public PriceMateriality.PriceMaterialityBuilder addSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSources) {
			if (secondaryRateSources != null) {
				for (final SettlementRateOption toAdd : secondaryRateSources) {
					this.secondaryRateSource.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("secondaryRateSource")
		@Override
		public PriceMateriality.PriceMaterialityBuilder setSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSources) {
			if (secondaryRateSources == null) {
				this.secondaryRateSource = new ArrayList<>();
			} else {
				this.secondaryRateSource = secondaryRateSources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("percentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("percentage")
		@Override
		public PriceMateriality.PriceMaterialityBuilder setPercentage(BigDecimal _percentage) {
			this.percentage = _percentage == null ? null : _percentage;
			return this;
		}
		
		@Override
		public PriceMateriality build() {
			return new PriceMateriality.PriceMaterialityImpl(this);
		}
		
		@Override
		public PriceMateriality.PriceMaterialityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceMateriality.PriceMaterialityBuilder prune() {
			super.prune();
			if (primaryRateSource!=null && !primaryRateSource.prune().hasData()) primaryRateSource = null;
			secondaryRateSource = secondaryRateSource.stream().filter(b->b!=null).<SettlementRateOption.SettlementRateOptionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPrimaryRateSource()!=null && getPrimaryRateSource().hasData()) return true;
			if (getSecondaryRateSource()!=null && getSecondaryRateSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPercentage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceMateriality.PriceMaterialityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PriceMateriality.PriceMaterialityBuilder o = (PriceMateriality.PriceMaterialityBuilder) other;
			
			merger.mergeRosetta(getPrimaryRateSource(), o.getPrimaryRateSource(), this::setPrimaryRateSource);
			merger.mergeRosetta(getSecondaryRateSource(), o.getSecondaryRateSource(), this::getOrCreateSecondaryRateSource);
			
			merger.mergeBasic(getPercentage(), o.getPercentage(), this::setPercentage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PriceMateriality _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!ListEquals.listEquals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(percentage, _that.getPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (percentage != null ? percentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceMaterialityBuilder {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"percentage=" + this.percentage +
			'}' + " " + super.toString();
		}
	}
}
