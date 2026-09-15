package drr.base.trade;

import cdm.base.staticdata.asset.common.AssetIdentifier;
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
import drr.base.trade.meta.ReportablePriceSourceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Provides the extraction of the Underlying Asset Price Source and correlate it with the identification of the trade products.
 * @version 7.7.0
 */
@RosettaDataType(value="ReportablePriceSource", builder=ReportablePriceSource.ReportablePriceSourceBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ReportablePriceSource", model="drr", builder=ReportablePriceSource.ReportablePriceSourceBuilderImpl.class, version="7.7.0")
public interface ReportablePriceSource extends RosettaModelObject {

	ReportablePriceSourceMeta metaData = new ReportablePriceSourceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the ProductIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
	 */
	List<? extends AssetIdentifier> getAssetIdentifier();
	/**
	 * Enables the identification of trade products with a specific Underlier ID (Other) that do not contain a productIdentifier and are, therefore, represented by a string (e.g., indexName).
	 */
	String getOtherId();
	/**
	 * For an underlying asset or benchmark not traded on a platform, the source of the price used to determine the value or level of the asset or benchmark.
	 */
	String getUnderlyingAssetPriceSource();

	/*********************** Build Methods  ***********************/
	ReportablePriceSource build();
	
	ReportablePriceSource.ReportablePriceSourceBuilder toBuilder();
	
	static ReportablePriceSource.ReportablePriceSourceBuilder builder() {
		return new ReportablePriceSource.ReportablePriceSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportablePriceSource> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportablePriceSource> getType() {
		return ReportablePriceSource.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("assetIdentifier"), processor, AssetIdentifier.class, getAssetIdentifier());
		processor.processBasic(path.newSubPath("otherId"), String.class, getOtherId(), this);
		processor.processBasic(path.newSubPath("underlyingAssetPriceSource"), String.class, getUnderlyingAssetPriceSource(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportablePriceSourceBuilder extends ReportablePriceSource, RosettaModelObjectBuilder {
		AssetIdentifier.AssetIdentifierBuilder getOrCreateAssetIdentifier(int index);
		@Override
		List<? extends AssetIdentifier.AssetIdentifierBuilder> getAssetIdentifier();
		ReportablePriceSource.ReportablePriceSourceBuilder addAssetIdentifier(AssetIdentifier assetIdentifier);
		ReportablePriceSource.ReportablePriceSourceBuilder addAssetIdentifier(AssetIdentifier assetIdentifier, int idx);
		ReportablePriceSource.ReportablePriceSourceBuilder addAssetIdentifier(List<? extends AssetIdentifier> assetIdentifier);
		ReportablePriceSource.ReportablePriceSourceBuilder setAssetIdentifier(List<? extends AssetIdentifier> assetIdentifier);
		ReportablePriceSource.ReportablePriceSourceBuilder setOtherId(String otherId);
		ReportablePriceSource.ReportablePriceSourceBuilder setUnderlyingAssetPriceSource(String underlyingAssetPriceSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("assetIdentifier"), processor, AssetIdentifier.AssetIdentifierBuilder.class, getAssetIdentifier());
			processor.processBasic(path.newSubPath("otherId"), String.class, getOtherId(), this);
			processor.processBasic(path.newSubPath("underlyingAssetPriceSource"), String.class, getUnderlyingAssetPriceSource(), this);
		}
		

		ReportablePriceSource.ReportablePriceSourceBuilder prune();
	}

	/*********************** Immutable Implementation of ReportablePriceSource  ***********************/
	class ReportablePriceSourceImpl implements ReportablePriceSource {
		private final List<? extends AssetIdentifier> assetIdentifier;
		private final String otherId;
		private final String underlyingAssetPriceSource;
		
		protected ReportablePriceSourceImpl(ReportablePriceSource.ReportablePriceSourceBuilder builder) {
			this.assetIdentifier = ofNullable(builder.getAssetIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.otherId = builder.getOtherId();
			this.underlyingAssetPriceSource = builder.getUnderlyingAssetPriceSource();
		}
		
		@Override
		@RosettaAttribute("assetIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("assetIdentifier")
		public List<? extends AssetIdentifier> getAssetIdentifier() {
			return assetIdentifier;
		}
		
		@Override
		@RosettaAttribute("otherId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherId")
		public String getOtherId() {
			return otherId;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		public String getUnderlyingAssetPriceSource() {
			return underlyingAssetPriceSource;
		}
		
		@Override
		public ReportablePriceSource build() {
			return this;
		}
		
		@Override
		public ReportablePriceSource.ReportablePriceSourceBuilder toBuilder() {
			ReportablePriceSource.ReportablePriceSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportablePriceSource.ReportablePriceSourceBuilder builder) {
			ofNullable(getAssetIdentifier()).ifPresent(builder::setAssetIdentifier);
			ofNullable(getOtherId()).ifPresent(builder::setOtherId);
			ofNullable(getUnderlyingAssetPriceSource()).ifPresent(builder::setUnderlyingAssetPriceSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportablePriceSource _that = getType().cast(o);
		
			if (!ListEquals.listEquals(assetIdentifier, _that.getAssetIdentifier())) return false;
			if (!Objects.equals(otherId, _that.getOtherId())) return false;
			if (!Objects.equals(underlyingAssetPriceSource, _that.getUnderlyingAssetPriceSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetIdentifier != null ? assetIdentifier.hashCode() : 0);
			_result = 31 * _result + (otherId != null ? otherId.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetPriceSource != null ? underlyingAssetPriceSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportablePriceSource {" +
				"assetIdentifier=" + this.assetIdentifier + ", " +
				"otherId=" + this.otherId + ", " +
				"underlyingAssetPriceSource=" + this.underlyingAssetPriceSource +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportablePriceSource  ***********************/
	class ReportablePriceSourceBuilderImpl implements ReportablePriceSource.ReportablePriceSourceBuilder {
	
		protected List<AssetIdentifier.AssetIdentifierBuilder> assetIdentifier = new ArrayList<>();
		protected String otherId;
		protected String underlyingAssetPriceSource;
		
		@Override
		@RosettaAttribute("assetIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("assetIdentifier")
		public List<? extends AssetIdentifier.AssetIdentifierBuilder> getAssetIdentifier() {
			return assetIdentifier;
		}
		
		@Override
		public AssetIdentifier.AssetIdentifierBuilder getOrCreateAssetIdentifier(int index) {
			if (assetIdentifier==null) {
				this.assetIdentifier = new ArrayList<>();
			}
			return getIndex(assetIdentifier, index, () -> {
						AssetIdentifier.AssetIdentifierBuilder newAssetIdentifier = AssetIdentifier.builder();
						return newAssetIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("otherId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otherId")
		public String getOtherId() {
			return otherId;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		public String getUnderlyingAssetPriceSource() {
			return underlyingAssetPriceSource;
		}
		
		@RosettaAttribute("assetIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("assetIdentifier")
		@Override
		public ReportablePriceSource.ReportablePriceSourceBuilder addAssetIdentifier(AssetIdentifier _assetIdentifier) {
			if (_assetIdentifier != null) {
				this.assetIdentifier.add(_assetIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportablePriceSource.ReportablePriceSourceBuilder addAssetIdentifier(AssetIdentifier _assetIdentifier, int idx) {
			getIndex(this.assetIdentifier, idx, () -> _assetIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ReportablePriceSource.ReportablePriceSourceBuilder addAssetIdentifier(List<? extends AssetIdentifier> assetIdentifiers) {
			if (assetIdentifiers != null) {
				for (final AssetIdentifier toAdd : assetIdentifiers) {
					this.assetIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("assetIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("assetIdentifier")
		@Override
		public ReportablePriceSource.ReportablePriceSourceBuilder setAssetIdentifier(List<? extends AssetIdentifier> assetIdentifiers) {
			if (assetIdentifiers == null) {
				this.assetIdentifier = new ArrayList<>();
			} else {
				this.assetIdentifier = assetIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("otherId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otherId")
		@Override
		public ReportablePriceSource.ReportablePriceSourceBuilder setOtherId(String _otherId) {
			this.otherId = _otherId == null ? null : _otherId;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPriceSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetPriceSource")
		@Override
		public ReportablePriceSource.ReportablePriceSourceBuilder setUnderlyingAssetPriceSource(String _underlyingAssetPriceSource) {
			this.underlyingAssetPriceSource = _underlyingAssetPriceSource == null ? null : _underlyingAssetPriceSource;
			return this;
		}
		
		@Override
		public ReportablePriceSource build() {
			return new ReportablePriceSource.ReportablePriceSourceImpl(this);
		}
		
		@Override
		public ReportablePriceSource.ReportablePriceSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportablePriceSource.ReportablePriceSourceBuilder prune() {
			assetIdentifier = assetIdentifier.stream().filter(b->b!=null).<AssetIdentifier.AssetIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAssetIdentifier()!=null && getAssetIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOtherId()!=null) return true;
			if (getUnderlyingAssetPriceSource()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportablePriceSource.ReportablePriceSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportablePriceSource.ReportablePriceSourceBuilder o = (ReportablePriceSource.ReportablePriceSourceBuilder) other;
			
			merger.mergeRosetta(getAssetIdentifier(), o.getAssetIdentifier(), this::getOrCreateAssetIdentifier);
			
			merger.mergeBasic(getOtherId(), o.getOtherId(), this::setOtherId);
			merger.mergeBasic(getUnderlyingAssetPriceSource(), o.getUnderlyingAssetPriceSource(), this::setUnderlyingAssetPriceSource);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportablePriceSource _that = getType().cast(o);
		
			if (!ListEquals.listEquals(assetIdentifier, _that.getAssetIdentifier())) return false;
			if (!Objects.equals(otherId, _that.getOtherId())) return false;
			if (!Objects.equals(underlyingAssetPriceSource, _that.getUnderlyingAssetPriceSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetIdentifier != null ? assetIdentifier.hashCode() : 0);
			_result = 31 * _result + (otherId != null ? otherId.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetPriceSource != null ? underlyingAssetPriceSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportablePriceSourceBuilder {" +
				"assetIdentifier=" + this.assetIdentifier + ", " +
				"otherId=" + this.otherId + ", " +
				"underlyingAssetPriceSource=" + this.underlyingAssetPriceSource +
			'}';
		}
	}
}
