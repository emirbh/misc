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
import fpml.consolidated.fx.meta.FxFallbackReferencePriceMeta;
import fpml.consolidated.shared.SettlementRateOption;
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
 * Provision Describes an alternative set of price sources
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes an alternative set of price sources
 *
 */
@RosettaDataType(value="FxFallbackReferencePrice", builder=FxFallbackReferencePrice.FxFallbackReferencePriceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxFallbackReferencePrice", model="fpml", builder=FxFallbackReferencePrice.FxFallbackReferencePriceBuilderImpl.class, version="2.1.1")
public interface FxFallbackReferencePrice extends FxDisruptionFallback {

	FxFallbackReferencePriceMeta metaData = new FxFallbackReferencePriceMeta();

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

	/*********************** Build Methods  ***********************/
	FxFallbackReferencePrice build();
	
	FxFallbackReferencePrice.FxFallbackReferencePriceBuilder toBuilder();
	
	static FxFallbackReferencePrice.FxFallbackReferencePriceBuilder builder() {
		return new FxFallbackReferencePrice.FxFallbackReferencePriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFallbackReferencePrice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxFallbackReferencePrice> getType() {
		return FxFallbackReferencePrice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("primaryRateSource"), processor, SettlementRateOption.class, getPrimaryRateSource());
		processRosetta(path.newSubPath("secondaryRateSource"), processor, SettlementRateOption.class, getSecondaryRateSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFallbackReferencePriceBuilder extends FxFallbackReferencePrice, FxDisruptionFallback.FxDisruptionFallbackBuilder {
		SettlementRateOption.SettlementRateOptionBuilder getOrCreatePrimaryRateSource();
		@Override
		SettlementRateOption.SettlementRateOptionBuilder getPrimaryRateSource();
		SettlementRateOption.SettlementRateOptionBuilder getOrCreateSecondaryRateSource(int index);
		@Override
		List<? extends SettlementRateOption.SettlementRateOptionBuilder> getSecondaryRateSource();
		FxFallbackReferencePrice.FxFallbackReferencePriceBuilder setPrimaryRateSource(SettlementRateOption primaryRateSource);
		FxFallbackReferencePrice.FxFallbackReferencePriceBuilder addSecondaryRateSource(SettlementRateOption secondaryRateSource);
		FxFallbackReferencePrice.FxFallbackReferencePriceBuilder addSecondaryRateSource(SettlementRateOption secondaryRateSource, int idx);
		FxFallbackReferencePrice.FxFallbackReferencePriceBuilder addSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSource);
		FxFallbackReferencePrice.FxFallbackReferencePriceBuilder setSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("primaryRateSource"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getPrimaryRateSource());
			processRosetta(path.newSubPath("secondaryRateSource"), processor, SettlementRateOption.SettlementRateOptionBuilder.class, getSecondaryRateSource());
		}
		

		FxFallbackReferencePrice.FxFallbackReferencePriceBuilder prune();
	}

	/*********************** Immutable Implementation of FxFallbackReferencePrice  ***********************/
	class FxFallbackReferencePriceImpl extends FxDisruptionFallback.FxDisruptionFallbackImpl implements FxFallbackReferencePrice {
		private final SettlementRateOption primaryRateSource;
		private final List<? extends SettlementRateOption> secondaryRateSource;
		
		protected FxFallbackReferencePriceImpl(FxFallbackReferencePrice.FxFallbackReferencePriceBuilder builder) {
			super(builder);
			this.primaryRateSource = ofNullable(builder.getPrimaryRateSource()).map(f->f.build()).orElse(null);
			this.secondaryRateSource = ofNullable(builder.getSecondaryRateSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		public FxFallbackReferencePrice build() {
			return this;
		}
		
		@Override
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder toBuilder() {
			FxFallbackReferencePrice.FxFallbackReferencePriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFallbackReferencePrice.FxFallbackReferencePriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPrimaryRateSource()).ifPresent(builder::setPrimaryRateSource);
			ofNullable(getSecondaryRateSource()).ifPresent(builder::setSecondaryRateSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFallbackReferencePrice _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!ListEquals.listEquals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFallbackReferencePrice {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxFallbackReferencePrice  ***********************/
	class FxFallbackReferencePriceBuilderImpl extends FxDisruptionFallback.FxDisruptionFallbackBuilderImpl implements FxFallbackReferencePrice.FxFallbackReferencePriceBuilder {
	
		protected SettlementRateOption.SettlementRateOptionBuilder primaryRateSource;
		protected List<SettlementRateOption.SettlementRateOptionBuilder> secondaryRateSource = new ArrayList<>();
		
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
		
		@RosettaAttribute("primaryRateSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryRateSource")
		@Override
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder setPrimaryRateSource(SettlementRateOption _primaryRateSource) {
			this.primaryRateSource = _primaryRateSource == null ? null : _primaryRateSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryRateSource")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryRateSource")
		@Override
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder addSecondaryRateSource(SettlementRateOption _secondaryRateSource) {
			if (_secondaryRateSource != null) {
				this.secondaryRateSource.add(_secondaryRateSource.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder addSecondaryRateSource(SettlementRateOption _secondaryRateSource, int idx) {
			getIndex(this.secondaryRateSource, idx, () -> _secondaryRateSource.toBuilder());
			return this;
		}
		
		@Override
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder addSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSources) {
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
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder setSecondaryRateSource(List<? extends SettlementRateOption> secondaryRateSources) {
			if (secondaryRateSources == null) {
				this.secondaryRateSource = new ArrayList<>();
			} else {
				this.secondaryRateSource = secondaryRateSources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxFallbackReferencePrice build() {
			return new FxFallbackReferencePrice.FxFallbackReferencePriceImpl(this);
		}
		
		@Override
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder prune() {
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
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFallbackReferencePrice.FxFallbackReferencePriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxFallbackReferencePrice.FxFallbackReferencePriceBuilder o = (FxFallbackReferencePrice.FxFallbackReferencePriceBuilder) other;
			
			merger.mergeRosetta(getPrimaryRateSource(), o.getPrimaryRateSource(), this::setPrimaryRateSource);
			merger.mergeRosetta(getSecondaryRateSource(), o.getSecondaryRateSource(), this::getOrCreateSecondaryRateSource);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxFallbackReferencePrice _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!ListEquals.listEquals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFallbackReferencePriceBuilder {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource +
			'}' + " " + super.toString();
		}
	}
}
