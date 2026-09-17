package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.GenericAssetMeta;
import fpml.consolidated.shared.InstrumentId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Concrete type to support public/private identifiers and classification (ISIN, CFI, ...) for an instrument of unspecified type. Derived as no-operation extension on IdentifedAsset (abstract base type).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Concrete type to support public/private identifiers and classification (ISIN, CFI, ...) for an instrument of unspecified type. Derived as no-operation extension on IdentifedAsset (abstract base type).
 *
 */
@RosettaDataType(value="GenericAsset", builder=GenericAsset.GenericAssetBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GenericAsset", model="fpml", builder=GenericAsset.GenericAssetBuilderImpl.class, version="2.1.1")
public interface GenericAsset extends IdentifiedAsset {

	GenericAssetMeta metaData = new GenericAssetMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	GenericAsset build();
	
	GenericAsset.GenericAssetBuilder toBuilder();
	
	static GenericAsset.GenericAssetBuilder builder() {
		return new GenericAsset.GenericAssetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericAsset> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GenericAsset> getType() {
		return GenericAsset.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.class, getInstrumentType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericAssetBuilder extends GenericAsset, IdentifiedAsset.IdentifiedAssetBuilder {
		@Override
		GenericAsset.GenericAssetBuilder setId(String id);
		@Override
		GenericAsset.GenericAssetBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		GenericAsset.GenericAssetBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		GenericAsset.GenericAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		GenericAsset.GenericAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		GenericAsset.GenericAssetBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		GenericAsset.GenericAssetBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		GenericAsset.GenericAssetBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		GenericAsset.GenericAssetBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		GenericAsset.GenericAssetBuilder setDescription(String description);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.InstrumentTypeBuilder.class, getInstrumentType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		}
		

		GenericAsset.GenericAssetBuilder prune();
	}

	/*********************** Immutable Implementation of GenericAsset  ***********************/
	class GenericAssetImpl extends IdentifiedAsset.IdentifiedAssetImpl implements GenericAsset {
		
		protected GenericAssetImpl(GenericAsset.GenericAssetBuilder builder) {
			super(builder);
		}
		
		@Override
		public GenericAsset build() {
			return this;
		}
		
		@Override
		public GenericAsset.GenericAssetBuilder toBuilder() {
			GenericAsset.GenericAssetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericAsset.GenericAssetBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericAsset {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GenericAsset  ***********************/
	class GenericAssetBuilderImpl extends IdentifiedAsset.IdentifiedAssetBuilderImpl implements GenericAsset.GenericAssetBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public GenericAsset.GenericAssetBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public GenericAsset.GenericAssetBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericAsset.GenericAssetBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public GenericAsset.GenericAssetBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public GenericAsset.GenericAssetBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public GenericAsset.GenericAssetBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public GenericAsset.GenericAssetBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public GenericAsset.GenericAssetBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes != null) {
				for (final InstrumentType toAdd : instrumentTypes) {
					this.instrumentType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public GenericAsset.GenericAssetBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes == null) {
				this.instrumentType = new ArrayList<>();
			} else {
				this.instrumentType = instrumentTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public GenericAsset.GenericAssetBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@Override
		public GenericAsset build() {
			return new GenericAsset.GenericAssetImpl(this);
		}
		
		@Override
		public GenericAsset.GenericAssetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericAsset.GenericAssetBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericAsset.GenericAssetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			GenericAsset.GenericAssetBuilder o = (GenericAsset.GenericAssetBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericAssetBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
