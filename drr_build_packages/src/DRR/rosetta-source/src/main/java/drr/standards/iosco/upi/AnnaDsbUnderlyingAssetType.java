package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbUnderlyingAssetTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbUnderlyingAssetType", builder=AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbUnderlyingAssetType", model="drr", builder=AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilderImpl.class, version="7.7.0")
public interface AnnaDsbUnderlyingAssetType extends RosettaModelObject {

	AnnaDsbUnderlyingAssetTypeMeta metaData = new AnnaDsbUnderlyingAssetTypeMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbCDSIndex getCDSIndex();
	AnnaDsbSingleName getSingleName();
	AnnaDsbCDSSingleName getCDSSingleName();
	AnnaDsbSingleStock getOptions();
	AnnaDsbSingleStock getFutures();
	AnnaDsbSingleStock getSingleStock();
	AnnaDsbSingleStock getForwards();
	AnnaDsbCDSSingleName getSwaps();
	AnnaDsbCDSIndex getIndex();
	AnnaDsbIndexTranche getIndexTranche();
	AnnaDsbCDSIndex getCDSIndexTranche();
	AnnaDsbOther getOther();

	/*********************** Build Methods  ***********************/
	AnnaDsbUnderlyingAssetType build();
	
	AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder toBuilder();
	
	static AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder builder() {
		return new AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbUnderlyingAssetType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbUnderlyingAssetType> getType() {
		return AnnaDsbUnderlyingAssetType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("CDSIndex"), processor, AnnaDsbCDSIndex.class, getCDSIndex());
		processRosetta(path.newSubPath("SingleName"), processor, AnnaDsbSingleName.class, getSingleName());
		processRosetta(path.newSubPath("CDSSingleName"), processor, AnnaDsbCDSSingleName.class, getCDSSingleName());
		processRosetta(path.newSubPath("Options"), processor, AnnaDsbSingleStock.class, getOptions());
		processRosetta(path.newSubPath("Futures"), processor, AnnaDsbSingleStock.class, getFutures());
		processRosetta(path.newSubPath("SingleStock"), processor, AnnaDsbSingleStock.class, getSingleStock());
		processRosetta(path.newSubPath("Forwards"), processor, AnnaDsbSingleStock.class, getForwards());
		processRosetta(path.newSubPath("Swaps"), processor, AnnaDsbCDSSingleName.class, getSwaps());
		processRosetta(path.newSubPath("Index"), processor, AnnaDsbCDSIndex.class, getIndex());
		processRosetta(path.newSubPath("IndexTranche"), processor, AnnaDsbIndexTranche.class, getIndexTranche());
		processRosetta(path.newSubPath("CDSIndexTranche"), processor, AnnaDsbCDSIndex.class, getCDSIndexTranche());
		processRosetta(path.newSubPath("Other"), processor, AnnaDsbOther.class, getOther());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbUnderlyingAssetTypeBuilder extends AnnaDsbUnderlyingAssetType, RosettaModelObjectBuilder {
		AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder getOrCreateCDSIndex();
		@Override
		AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder getCDSIndex();
		AnnaDsbSingleName.AnnaDsbSingleNameBuilder getOrCreateSingleName();
		@Override
		AnnaDsbSingleName.AnnaDsbSingleNameBuilder getSingleName();
		AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder getOrCreateCDSSingleName();
		@Override
		AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder getCDSSingleName();
		AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getOrCreateOptions();
		@Override
		AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getOptions();
		AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getOrCreateFutures();
		@Override
		AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getFutures();
		AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getOrCreateSingleStock();
		@Override
		AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getSingleStock();
		AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getOrCreateForwards();
		@Override
		AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getForwards();
		AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder getOrCreateSwaps();
		@Override
		AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder getSwaps();
		AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder getOrCreateIndex();
		@Override
		AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder getIndex();
		AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder getOrCreateIndexTranche();
		@Override
		AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder getIndexTranche();
		AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder getOrCreateCDSIndexTranche();
		@Override
		AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder getCDSIndexTranche();
		AnnaDsbOther.AnnaDsbOtherBuilder getOrCreateOther();
		@Override
		AnnaDsbOther.AnnaDsbOtherBuilder getOther();
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setCDSIndex(AnnaDsbCDSIndex CDSIndex);
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setSingleName(AnnaDsbSingleName SingleName);
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setCDSSingleName(AnnaDsbCDSSingleName CDSSingleName);
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setOptions(AnnaDsbSingleStock Options);
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setFutures(AnnaDsbSingleStock Futures);
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setSingleStock(AnnaDsbSingleStock SingleStock);
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setForwards(AnnaDsbSingleStock Forwards);
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setSwaps(AnnaDsbCDSSingleName Swaps);
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setIndex(AnnaDsbCDSIndex Index);
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setIndexTranche(AnnaDsbIndexTranche IndexTranche);
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setCDSIndexTranche(AnnaDsbCDSIndex CDSIndexTranche);
		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setOther(AnnaDsbOther Other);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("CDSIndex"), processor, AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder.class, getCDSIndex());
			processRosetta(path.newSubPath("SingleName"), processor, AnnaDsbSingleName.AnnaDsbSingleNameBuilder.class, getSingleName());
			processRosetta(path.newSubPath("CDSSingleName"), processor, AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder.class, getCDSSingleName());
			processRosetta(path.newSubPath("Options"), processor, AnnaDsbSingleStock.AnnaDsbSingleStockBuilder.class, getOptions());
			processRosetta(path.newSubPath("Futures"), processor, AnnaDsbSingleStock.AnnaDsbSingleStockBuilder.class, getFutures());
			processRosetta(path.newSubPath("SingleStock"), processor, AnnaDsbSingleStock.AnnaDsbSingleStockBuilder.class, getSingleStock());
			processRosetta(path.newSubPath("Forwards"), processor, AnnaDsbSingleStock.AnnaDsbSingleStockBuilder.class, getForwards());
			processRosetta(path.newSubPath("Swaps"), processor, AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder.class, getSwaps());
			processRosetta(path.newSubPath("Index"), processor, AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder.class, getIndex());
			processRosetta(path.newSubPath("IndexTranche"), processor, AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder.class, getIndexTranche());
			processRosetta(path.newSubPath("CDSIndexTranche"), processor, AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder.class, getCDSIndexTranche());
			processRosetta(path.newSubPath("Other"), processor, AnnaDsbOther.AnnaDsbOtherBuilder.class, getOther());
		}
		

		AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbUnderlyingAssetType  ***********************/
	class AnnaDsbUnderlyingAssetTypeImpl implements AnnaDsbUnderlyingAssetType {
		private final AnnaDsbCDSIndex cDSIndex;
		private final AnnaDsbSingleName singleName;
		private final AnnaDsbCDSSingleName cDSSingleName;
		private final AnnaDsbSingleStock options;
		private final AnnaDsbSingleStock futures;
		private final AnnaDsbSingleStock singleStock;
		private final AnnaDsbSingleStock forwards;
		private final AnnaDsbCDSSingleName swaps;
		private final AnnaDsbCDSIndex index;
		private final AnnaDsbIndexTranche indexTranche;
		private final AnnaDsbCDSIndex cDSIndexTranche;
		private final AnnaDsbOther other;
		
		protected AnnaDsbUnderlyingAssetTypeImpl(AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder builder) {
			this.cDSIndex = ofNullable(builder.getCDSIndex()).map(f->f.build()).orElse(null);
			this.singleName = ofNullable(builder.getSingleName()).map(f->f.build()).orElse(null);
			this.cDSSingleName = ofNullable(builder.getCDSSingleName()).map(f->f.build()).orElse(null);
			this.options = ofNullable(builder.getOptions()).map(f->f.build()).orElse(null);
			this.futures = ofNullable(builder.getFutures()).map(f->f.build()).orElse(null);
			this.singleStock = ofNullable(builder.getSingleStock()).map(f->f.build()).orElse(null);
			this.forwards = ofNullable(builder.getForwards()).map(f->f.build()).orElse(null);
			this.swaps = ofNullable(builder.getSwaps()).map(f->f.build()).orElse(null);
			this.index = ofNullable(builder.getIndex()).map(f->f.build()).orElse(null);
			this.indexTranche = ofNullable(builder.getIndexTranche()).map(f->f.build()).orElse(null);
			this.cDSIndexTranche = ofNullable(builder.getCDSIndexTranche()).map(f->f.build()).orElse(null);
			this.other = ofNullable(builder.getOther()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("CDSIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CDSIndex")
		public AnnaDsbCDSIndex getCDSIndex() {
			return cDSIndex;
		}
		
		@Override
		@RosettaAttribute("SingleName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SingleName")
		public AnnaDsbSingleName getSingleName() {
			return singleName;
		}
		
		@Override
		@RosettaAttribute("CDSSingleName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CDSSingleName")
		public AnnaDsbCDSSingleName getCDSSingleName() {
			return cDSSingleName;
		}
		
		@Override
		@RosettaAttribute("Options")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Options")
		public AnnaDsbSingleStock getOptions() {
			return options;
		}
		
		@Override
		@RosettaAttribute("Futures")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Futures")
		public AnnaDsbSingleStock getFutures() {
			return futures;
		}
		
		@Override
		@RosettaAttribute("SingleStock")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SingleStock")
		public AnnaDsbSingleStock getSingleStock() {
			return singleStock;
		}
		
		@Override
		@RosettaAttribute("Forwards")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Forwards")
		public AnnaDsbSingleStock getForwards() {
			return forwards;
		}
		
		@Override
		@RosettaAttribute("Swaps")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Swaps")
		public AnnaDsbCDSSingleName getSwaps() {
			return swaps;
		}
		
		@Override
		@RosettaAttribute("Index")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Index")
		public AnnaDsbCDSIndex getIndex() {
			return index;
		}
		
		@Override
		@RosettaAttribute("IndexTranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("IndexTranche")
		public AnnaDsbIndexTranche getIndexTranche() {
			return indexTranche;
		}
		
		@Override
		@RosettaAttribute("CDSIndexTranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CDSIndexTranche")
		public AnnaDsbCDSIndex getCDSIndexTranche() {
			return cDSIndexTranche;
		}
		
		@Override
		@RosettaAttribute("Other")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Other")
		public AnnaDsbOther getOther() {
			return other;
		}
		
		@Override
		public AnnaDsbUnderlyingAssetType build() {
			return this;
		}
		
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder toBuilder() {
			AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder builder) {
			ofNullable(getCDSIndex()).ifPresent(builder::setCDSIndex);
			ofNullable(getSingleName()).ifPresent(builder::setSingleName);
			ofNullable(getCDSSingleName()).ifPresent(builder::setCDSSingleName);
			ofNullable(getOptions()).ifPresent(builder::setOptions);
			ofNullable(getFutures()).ifPresent(builder::setFutures);
			ofNullable(getSingleStock()).ifPresent(builder::setSingleStock);
			ofNullable(getForwards()).ifPresent(builder::setForwards);
			ofNullable(getSwaps()).ifPresent(builder::setSwaps);
			ofNullable(getIndex()).ifPresent(builder::setIndex);
			ofNullable(getIndexTranche()).ifPresent(builder::setIndexTranche);
			ofNullable(getCDSIndexTranche()).ifPresent(builder::setCDSIndexTranche);
			ofNullable(getOther()).ifPresent(builder::setOther);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUnderlyingAssetType _that = getType().cast(o);
		
			if (!Objects.equals(cDSIndex, _that.getCDSIndex())) return false;
			if (!Objects.equals(singleName, _that.getSingleName())) return false;
			if (!Objects.equals(cDSSingleName, _that.getCDSSingleName())) return false;
			if (!Objects.equals(options, _that.getOptions())) return false;
			if (!Objects.equals(futures, _that.getFutures())) return false;
			if (!Objects.equals(singleStock, _that.getSingleStock())) return false;
			if (!Objects.equals(forwards, _that.getForwards())) return false;
			if (!Objects.equals(swaps, _that.getSwaps())) return false;
			if (!Objects.equals(index, _that.getIndex())) return false;
			if (!Objects.equals(indexTranche, _that.getIndexTranche())) return false;
			if (!Objects.equals(cDSIndexTranche, _that.getCDSIndexTranche())) return false;
			if (!Objects.equals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cDSIndex != null ? cDSIndex.hashCode() : 0);
			_result = 31 * _result + (singleName != null ? singleName.hashCode() : 0);
			_result = 31 * _result + (cDSSingleName != null ? cDSSingleName.hashCode() : 0);
			_result = 31 * _result + (options != null ? options.hashCode() : 0);
			_result = 31 * _result + (futures != null ? futures.hashCode() : 0);
			_result = 31 * _result + (singleStock != null ? singleStock.hashCode() : 0);
			_result = 31 * _result + (forwards != null ? forwards.hashCode() : 0);
			_result = 31 * _result + (swaps != null ? swaps.hashCode() : 0);
			_result = 31 * _result + (index != null ? index.hashCode() : 0);
			_result = 31 * _result + (indexTranche != null ? indexTranche.hashCode() : 0);
			_result = 31 * _result + (cDSIndexTranche != null ? cDSIndexTranche.hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUnderlyingAssetType {" +
				"CDSIndex=" + this.cDSIndex + ", " +
				"SingleName=" + this.singleName + ", " +
				"CDSSingleName=" + this.cDSSingleName + ", " +
				"Options=" + this.options + ", " +
				"Futures=" + this.futures + ", " +
				"SingleStock=" + this.singleStock + ", " +
				"Forwards=" + this.forwards + ", " +
				"Swaps=" + this.swaps + ", " +
				"Index=" + this.index + ", " +
				"IndexTranche=" + this.indexTranche + ", " +
				"CDSIndexTranche=" + this.cDSIndexTranche + ", " +
				"Other=" + this.other +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbUnderlyingAssetType  ***********************/
	class AnnaDsbUnderlyingAssetTypeBuilderImpl implements AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder {
	
		protected AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder cDSIndex;
		protected AnnaDsbSingleName.AnnaDsbSingleNameBuilder singleName;
		protected AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder cDSSingleName;
		protected AnnaDsbSingleStock.AnnaDsbSingleStockBuilder options;
		protected AnnaDsbSingleStock.AnnaDsbSingleStockBuilder futures;
		protected AnnaDsbSingleStock.AnnaDsbSingleStockBuilder singleStock;
		protected AnnaDsbSingleStock.AnnaDsbSingleStockBuilder forwards;
		protected AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder swaps;
		protected AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder index;
		protected AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder indexTranche;
		protected AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder cDSIndexTranche;
		protected AnnaDsbOther.AnnaDsbOtherBuilder other;
		
		@Override
		@RosettaAttribute("CDSIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CDSIndex")
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder getCDSIndex() {
			return cDSIndex;
		}
		
		@Override
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder getOrCreateCDSIndex() {
			AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder result;
			if (cDSIndex!=null) {
				result = cDSIndex;
			}
			else {
				result = cDSIndex = AnnaDsbCDSIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("SingleName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SingleName")
		public AnnaDsbSingleName.AnnaDsbSingleNameBuilder getSingleName() {
			return singleName;
		}
		
		@Override
		public AnnaDsbSingleName.AnnaDsbSingleNameBuilder getOrCreateSingleName() {
			AnnaDsbSingleName.AnnaDsbSingleNameBuilder result;
			if (singleName!=null) {
				result = singleName;
			}
			else {
				result = singleName = AnnaDsbSingleName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("CDSSingleName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CDSSingleName")
		public AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder getCDSSingleName() {
			return cDSSingleName;
		}
		
		@Override
		public AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder getOrCreateCDSSingleName() {
			AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder result;
			if (cDSSingleName!=null) {
				result = cDSSingleName;
			}
			else {
				result = cDSSingleName = AnnaDsbCDSSingleName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Options")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Options")
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getOptions() {
			return options;
		}
		
		@Override
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getOrCreateOptions() {
			AnnaDsbSingleStock.AnnaDsbSingleStockBuilder result;
			if (options!=null) {
				result = options;
			}
			else {
				result = options = AnnaDsbSingleStock.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Futures")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Futures")
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getFutures() {
			return futures;
		}
		
		@Override
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getOrCreateFutures() {
			AnnaDsbSingleStock.AnnaDsbSingleStockBuilder result;
			if (futures!=null) {
				result = futures;
			}
			else {
				result = futures = AnnaDsbSingleStock.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("SingleStock")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SingleStock")
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getSingleStock() {
			return singleStock;
		}
		
		@Override
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getOrCreateSingleStock() {
			AnnaDsbSingleStock.AnnaDsbSingleStockBuilder result;
			if (singleStock!=null) {
				result = singleStock;
			}
			else {
				result = singleStock = AnnaDsbSingleStock.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Forwards")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Forwards")
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getForwards() {
			return forwards;
		}
		
		@Override
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder getOrCreateForwards() {
			AnnaDsbSingleStock.AnnaDsbSingleStockBuilder result;
			if (forwards!=null) {
				result = forwards;
			}
			else {
				result = forwards = AnnaDsbSingleStock.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Swaps")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Swaps")
		public AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder getSwaps() {
			return swaps;
		}
		
		@Override
		public AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder getOrCreateSwaps() {
			AnnaDsbCDSSingleName.AnnaDsbCDSSingleNameBuilder result;
			if (swaps!=null) {
				result = swaps;
			}
			else {
				result = swaps = AnnaDsbCDSSingleName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Index")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Index")
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder getIndex() {
			return index;
		}
		
		@Override
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder getOrCreateIndex() {
			AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder result;
			if (index!=null) {
				result = index;
			}
			else {
				result = index = AnnaDsbCDSIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("IndexTranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("IndexTranche")
		public AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder getIndexTranche() {
			return indexTranche;
		}
		
		@Override
		public AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder getOrCreateIndexTranche() {
			AnnaDsbIndexTranche.AnnaDsbIndexTrancheBuilder result;
			if (indexTranche!=null) {
				result = indexTranche;
			}
			else {
				result = indexTranche = AnnaDsbIndexTranche.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("CDSIndexTranche")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CDSIndexTranche")
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder getCDSIndexTranche() {
			return cDSIndexTranche;
		}
		
		@Override
		public AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder getOrCreateCDSIndexTranche() {
			AnnaDsbCDSIndex.AnnaDsbCDSIndexBuilder result;
			if (cDSIndexTranche!=null) {
				result = cDSIndexTranche;
			}
			else {
				result = cDSIndexTranche = AnnaDsbCDSIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Other")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Other")
		public AnnaDsbOther.AnnaDsbOtherBuilder getOther() {
			return other;
		}
		
		@Override
		public AnnaDsbOther.AnnaDsbOtherBuilder getOrCreateOther() {
			AnnaDsbOther.AnnaDsbOtherBuilder result;
			if (other!=null) {
				result = other;
			}
			else {
				result = other = AnnaDsbOther.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("CDSIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("CDSIndex")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setCDSIndex(AnnaDsbCDSIndex _cDSIndex) {
			this.cDSIndex = _cDSIndex == null ? null : _cDSIndex.toBuilder();
			return this;
		}
		
		@RosettaAttribute("SingleName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("SingleName")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setSingleName(AnnaDsbSingleName _singleName) {
			this.singleName = _singleName == null ? null : _singleName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("CDSSingleName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("CDSSingleName")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setCDSSingleName(AnnaDsbCDSSingleName _cDSSingleName) {
			this.cDSSingleName = _cDSSingleName == null ? null : _cDSSingleName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Options")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Options")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setOptions(AnnaDsbSingleStock _options) {
			this.options = _options == null ? null : _options.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Futures")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Futures")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setFutures(AnnaDsbSingleStock _futures) {
			this.futures = _futures == null ? null : _futures.toBuilder();
			return this;
		}
		
		@RosettaAttribute("SingleStock")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("SingleStock")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setSingleStock(AnnaDsbSingleStock _singleStock) {
			this.singleStock = _singleStock == null ? null : _singleStock.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Forwards")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Forwards")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setForwards(AnnaDsbSingleStock _forwards) {
			this.forwards = _forwards == null ? null : _forwards.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Swaps")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Swaps")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setSwaps(AnnaDsbCDSSingleName _swaps) {
			this.swaps = _swaps == null ? null : _swaps.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Index")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Index")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setIndex(AnnaDsbCDSIndex _index) {
			this.index = _index == null ? null : _index.toBuilder();
			return this;
		}
		
		@RosettaAttribute("IndexTranche")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("IndexTranche")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setIndexTranche(AnnaDsbIndexTranche _indexTranche) {
			this.indexTranche = _indexTranche == null ? null : _indexTranche.toBuilder();
			return this;
		}
		
		@RosettaAttribute("CDSIndexTranche")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("CDSIndexTranche")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setCDSIndexTranche(AnnaDsbCDSIndex _cDSIndexTranche) {
			this.cDSIndexTranche = _cDSIndexTranche == null ? null : _cDSIndexTranche.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Other")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Other")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder setOther(AnnaDsbOther _other) {
			this.other = _other == null ? null : _other.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbUnderlyingAssetType build() {
			return new AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeImpl(this);
		}
		
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder prune() {
			if (cDSIndex!=null && !cDSIndex.prune().hasData()) cDSIndex = null;
			if (singleName!=null && !singleName.prune().hasData()) singleName = null;
			if (cDSSingleName!=null && !cDSSingleName.prune().hasData()) cDSSingleName = null;
			if (options!=null && !options.prune().hasData()) options = null;
			if (futures!=null && !futures.prune().hasData()) futures = null;
			if (singleStock!=null && !singleStock.prune().hasData()) singleStock = null;
			if (forwards!=null && !forwards.prune().hasData()) forwards = null;
			if (swaps!=null && !swaps.prune().hasData()) swaps = null;
			if (index!=null && !index.prune().hasData()) index = null;
			if (indexTranche!=null && !indexTranche.prune().hasData()) indexTranche = null;
			if (cDSIndexTranche!=null && !cDSIndexTranche.prune().hasData()) cDSIndexTranche = null;
			if (other!=null && !other.prune().hasData()) other = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCDSIndex()!=null && getCDSIndex().hasData()) return true;
			if (getSingleName()!=null && getSingleName().hasData()) return true;
			if (getCDSSingleName()!=null && getCDSSingleName().hasData()) return true;
			if (getOptions()!=null && getOptions().hasData()) return true;
			if (getFutures()!=null && getFutures().hasData()) return true;
			if (getSingleStock()!=null && getSingleStock().hasData()) return true;
			if (getForwards()!=null && getForwards().hasData()) return true;
			if (getSwaps()!=null && getSwaps().hasData()) return true;
			if (getIndex()!=null && getIndex().hasData()) return true;
			if (getIndexTranche()!=null && getIndexTranche().hasData()) return true;
			if (getCDSIndexTranche()!=null && getCDSIndexTranche().hasData()) return true;
			if (getOther()!=null && getOther().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder o = (AnnaDsbUnderlyingAssetType.AnnaDsbUnderlyingAssetTypeBuilder) other;
			
			merger.mergeRosetta(getCDSIndex(), o.getCDSIndex(), this::setCDSIndex);
			merger.mergeRosetta(getSingleName(), o.getSingleName(), this::setSingleName);
			merger.mergeRosetta(getCDSSingleName(), o.getCDSSingleName(), this::setCDSSingleName);
			merger.mergeRosetta(getOptions(), o.getOptions(), this::setOptions);
			merger.mergeRosetta(getFutures(), o.getFutures(), this::setFutures);
			merger.mergeRosetta(getSingleStock(), o.getSingleStock(), this::setSingleStock);
			merger.mergeRosetta(getForwards(), o.getForwards(), this::setForwards);
			merger.mergeRosetta(getSwaps(), o.getSwaps(), this::setSwaps);
			merger.mergeRosetta(getIndex(), o.getIndex(), this::setIndex);
			merger.mergeRosetta(getIndexTranche(), o.getIndexTranche(), this::setIndexTranche);
			merger.mergeRosetta(getCDSIndexTranche(), o.getCDSIndexTranche(), this::setCDSIndexTranche);
			merger.mergeRosetta(getOther(), o.getOther(), this::setOther);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUnderlyingAssetType _that = getType().cast(o);
		
			if (!Objects.equals(cDSIndex, _that.getCDSIndex())) return false;
			if (!Objects.equals(singleName, _that.getSingleName())) return false;
			if (!Objects.equals(cDSSingleName, _that.getCDSSingleName())) return false;
			if (!Objects.equals(options, _that.getOptions())) return false;
			if (!Objects.equals(futures, _that.getFutures())) return false;
			if (!Objects.equals(singleStock, _that.getSingleStock())) return false;
			if (!Objects.equals(forwards, _that.getForwards())) return false;
			if (!Objects.equals(swaps, _that.getSwaps())) return false;
			if (!Objects.equals(index, _that.getIndex())) return false;
			if (!Objects.equals(indexTranche, _that.getIndexTranche())) return false;
			if (!Objects.equals(cDSIndexTranche, _that.getCDSIndexTranche())) return false;
			if (!Objects.equals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cDSIndex != null ? cDSIndex.hashCode() : 0);
			_result = 31 * _result + (singleName != null ? singleName.hashCode() : 0);
			_result = 31 * _result + (cDSSingleName != null ? cDSSingleName.hashCode() : 0);
			_result = 31 * _result + (options != null ? options.hashCode() : 0);
			_result = 31 * _result + (futures != null ? futures.hashCode() : 0);
			_result = 31 * _result + (singleStock != null ? singleStock.hashCode() : 0);
			_result = 31 * _result + (forwards != null ? forwards.hashCode() : 0);
			_result = 31 * _result + (swaps != null ? swaps.hashCode() : 0);
			_result = 31 * _result + (index != null ? index.hashCode() : 0);
			_result = 31 * _result + (indexTranche != null ? indexTranche.hashCode() : 0);
			_result = 31 * _result + (cDSIndexTranche != null ? cDSIndexTranche.hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUnderlyingAssetTypeBuilder {" +
				"CDSIndex=" + this.cDSIndex + ", " +
				"SingleName=" + this.singleName + ", " +
				"CDSSingleName=" + this.cDSSingleName + ", " +
				"Options=" + this.options + ", " +
				"Futures=" + this.futures + ", " +
				"SingleStock=" + this.singleStock + ", " +
				"Forwards=" + this.forwards + ", " +
				"Swaps=" + this.swaps + ", " +
				"Index=" + this.index + ", " +
				"IndexTranche=" + this.indexTranche + ", " +
				"CDSIndexTranche=" + this.cDSIndexTranche + ", " +
				"Other=" + this.other +
			'}';
		}
	}
}
