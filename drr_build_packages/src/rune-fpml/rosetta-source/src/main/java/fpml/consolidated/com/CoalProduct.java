package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CoalProductMeta;
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
 * Provision A type defining the characteristics of the coal being traded in a physically settled gas transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the characteristics of the coal being traded in a physically settled gas transaction.
 *
 */
@RosettaDataType(value="CoalProduct", builder=CoalProduct.CoalProductBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CoalProduct", model="fpml", builder=CoalProduct.CoalProductBuilderImpl.class, version="2.1.1")
public interface CoalProduct extends RosettaModelObject {

	CoalProductMeta metaData = new CoalProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of coal product to be delivered by reference to a pre-defined specification. For contracts under SCoTA terms this is the quality specification code (e.g. "DES ARA")
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of coal product to be delivered by reference to a pre-defined specification. For contracts under SCoTA terms this is the quality specification code (e.g. "DES ARA")
	 *
	 */
	CoalProductType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of coal product to be delivered specified in full.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of coal product to be delivered specified in full.
	 *
	 */
	CoalProductSpecifications getCoalProductSpecifications();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The SCoTA cargo origin, mining region, mine(s), mining complex(es), loadout(s) or river dock(s) or other point(s) of origin that Seller and Buyer agree are acceptable origins for the Coal Product. For International Coal transactions, this is the Origin of the Coal Product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The SCoTA cargo origin, mining region, mine(s), mining complex(es), loadout(s) or river dock(s) or other point(s) of origin that Seller and Buyer agree are acceptable origins for the Coal Product. For International Coal transactions, this is the Origin of the Coal Product.
	 *
	 */
	List<? extends CoalProductSource> getSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates whether type and source refer to globalCOAL SCoTA specifications.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates whether type and source refer to globalCOAL SCoTA specifications.
	 *
	 */
	Boolean getSCoTASpecifications();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Quality Adjustment formula to be used where the Actual Shipment BTU/Lb value differs from the Standard BTU/Lb value.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Quality Adjustment formula to be used where the Actual Shipment BTU/Lb value differs from the Standard BTU/Lb value.
	 *
	 */
	CoalQualityAdjustments getBtuQualityAdjustment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Quality Adjustment formula to be used where the Actual Shipment SO2/MMBTU value differs from the Standard SO2/MMBTU value.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Quality Adjustment formula to be used where the Actual Shipment SO2/MMBTU value differs from the Standard SO2/MMBTU value.
	 *
	 */
	CoalQualityAdjustments getSo2QualityAdjustment();

	/*********************** Build Methods  ***********************/
	CoalProduct build();
	
	CoalProduct.CoalProductBuilder toBuilder();
	
	static CoalProduct.CoalProductBuilder builder() {
		return new CoalProduct.CoalProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalProduct> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CoalProduct> getType() {
		return CoalProduct.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("type"), processor, CoalProductType.class, _getType());
		processRosetta(path.newSubPath("coalProductSpecifications"), processor, CoalProductSpecifications.class, getCoalProductSpecifications());
		processRosetta(path.newSubPath("source"), processor, CoalProductSource.class, getSource());
		processor.processBasic(path.newSubPath("sCoTASpecifications"), Boolean.class, getSCoTASpecifications(), this);
		processRosetta(path.newSubPath("btuQualityAdjustment"), processor, CoalQualityAdjustments.class, getBtuQualityAdjustment());
		processRosetta(path.newSubPath("so2QualityAdjustment"), processor, CoalQualityAdjustments.class, getSo2QualityAdjustment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalProductBuilder extends CoalProduct, RosettaModelObjectBuilder {
		CoalProductType.CoalProductTypeBuilder getOrCreateType();
		@Override
		CoalProductType.CoalProductTypeBuilder _getType();
		CoalProductSpecifications.CoalProductSpecificationsBuilder getOrCreateCoalProductSpecifications();
		@Override
		CoalProductSpecifications.CoalProductSpecificationsBuilder getCoalProductSpecifications();
		CoalProductSource.CoalProductSourceBuilder getOrCreateSource(int index);
		@Override
		List<? extends CoalProductSource.CoalProductSourceBuilder> getSource();
		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getOrCreateBtuQualityAdjustment();
		@Override
		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getBtuQualityAdjustment();
		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getOrCreateSo2QualityAdjustment();
		@Override
		CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getSo2QualityAdjustment();
		CoalProduct.CoalProductBuilder setType(CoalProductType type);
		CoalProduct.CoalProductBuilder setCoalProductSpecifications(CoalProductSpecifications coalProductSpecifications);
		CoalProduct.CoalProductBuilder addSource(CoalProductSource source);
		CoalProduct.CoalProductBuilder addSource(CoalProductSource source, int idx);
		CoalProduct.CoalProductBuilder addSource(List<? extends CoalProductSource> source);
		CoalProduct.CoalProductBuilder setSource(List<? extends CoalProductSource> source);
		CoalProduct.CoalProductBuilder setSCoTASpecifications(Boolean sCoTASpecifications);
		CoalProduct.CoalProductBuilder setBtuQualityAdjustment(CoalQualityAdjustments btuQualityAdjustment);
		CoalProduct.CoalProductBuilder setSo2QualityAdjustment(CoalQualityAdjustments so2QualityAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("type"), processor, CoalProductType.CoalProductTypeBuilder.class, _getType());
			processRosetta(path.newSubPath("coalProductSpecifications"), processor, CoalProductSpecifications.CoalProductSpecificationsBuilder.class, getCoalProductSpecifications());
			processRosetta(path.newSubPath("source"), processor, CoalProductSource.CoalProductSourceBuilder.class, getSource());
			processor.processBasic(path.newSubPath("sCoTASpecifications"), Boolean.class, getSCoTASpecifications(), this);
			processRosetta(path.newSubPath("btuQualityAdjustment"), processor, CoalQualityAdjustments.CoalQualityAdjustmentsBuilder.class, getBtuQualityAdjustment());
			processRosetta(path.newSubPath("so2QualityAdjustment"), processor, CoalQualityAdjustments.CoalQualityAdjustmentsBuilder.class, getSo2QualityAdjustment());
		}
		

		CoalProduct.CoalProductBuilder prune();
	}

	/*********************** Immutable Implementation of CoalProduct  ***********************/
	class CoalProductImpl implements CoalProduct {
		private final CoalProductType type;
		private final CoalProductSpecifications coalProductSpecifications;
		private final List<? extends CoalProductSource> source;
		private final Boolean sCoTASpecifications;
		private final CoalQualityAdjustments btuQualityAdjustment;
		private final CoalQualityAdjustments so2QualityAdjustment;
		
		protected CoalProductImpl(CoalProduct.CoalProductBuilder builder) {
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.coalProductSpecifications = ofNullable(builder.getCoalProductSpecifications()).map(f->f.build()).orElse(null);
			this.source = ofNullable(builder.getSource()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.sCoTASpecifications = builder.getSCoTASpecifications();
			this.btuQualityAdjustment = ofNullable(builder.getBtuQualityAdjustment()).map(f->f.build()).orElse(null);
			this.so2QualityAdjustment = ofNullable(builder.getSo2QualityAdjustment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public CoalProductType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("coalProductSpecifications")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coalProductSpecifications")
		public CoalProductSpecifications getCoalProductSpecifications() {
			return coalProductSpecifications;
		}
		
		@Override
		@RosettaAttribute("source")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("source")
		public List<? extends CoalProductSource> getSource() {
			return source;
		}
		
		@Override
		@RosettaAttribute("sCoTASpecifications")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sCoTASpecifications")
		public Boolean getSCoTASpecifications() {
			return sCoTASpecifications;
		}
		
		@Override
		@RosettaAttribute("btuQualityAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("btuQualityAdjustment")
		public CoalQualityAdjustments getBtuQualityAdjustment() {
			return btuQualityAdjustment;
		}
		
		@Override
		@RosettaAttribute("so2QualityAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("so2QualityAdjustment")
		public CoalQualityAdjustments getSo2QualityAdjustment() {
			return so2QualityAdjustment;
		}
		
		@Override
		public CoalProduct build() {
			return this;
		}
		
		@Override
		public CoalProduct.CoalProductBuilder toBuilder() {
			CoalProduct.CoalProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalProduct.CoalProductBuilder builder) {
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getCoalProductSpecifications()).ifPresent(builder::setCoalProductSpecifications);
			ofNullable(getSource()).ifPresent(builder::setSource);
			ofNullable(getSCoTASpecifications()).ifPresent(builder::setSCoTASpecifications);
			ofNullable(getBtuQualityAdjustment()).ifPresent(builder::setBtuQualityAdjustment);
			ofNullable(getSo2QualityAdjustment()).ifPresent(builder::setSo2QualityAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalProduct _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(coalProductSpecifications, _that.getCoalProductSpecifications())) return false;
			if (!ListEquals.listEquals(source, _that.getSource())) return false;
			if (!Objects.equals(sCoTASpecifications, _that.getSCoTASpecifications())) return false;
			if (!Objects.equals(btuQualityAdjustment, _that.getBtuQualityAdjustment())) return false;
			if (!Objects.equals(so2QualityAdjustment, _that.getSo2QualityAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (coalProductSpecifications != null ? coalProductSpecifications.hashCode() : 0);
			_result = 31 * _result + (source != null ? source.hashCode() : 0);
			_result = 31 * _result + (sCoTASpecifications != null ? sCoTASpecifications.hashCode() : 0);
			_result = 31 * _result + (btuQualityAdjustment != null ? btuQualityAdjustment.hashCode() : 0);
			_result = 31 * _result + (so2QualityAdjustment != null ? so2QualityAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalProduct {" +
				"type=" + this.type + ", " +
				"coalProductSpecifications=" + this.coalProductSpecifications + ", " +
				"source=" + this.source + ", " +
				"sCoTASpecifications=" + this.sCoTASpecifications + ", " +
				"btuQualityAdjustment=" + this.btuQualityAdjustment + ", " +
				"so2QualityAdjustment=" + this.so2QualityAdjustment +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalProduct  ***********************/
	class CoalProductBuilderImpl implements CoalProduct.CoalProductBuilder {
	
		protected CoalProductType.CoalProductTypeBuilder type;
		protected CoalProductSpecifications.CoalProductSpecificationsBuilder coalProductSpecifications;
		protected List<CoalProductSource.CoalProductSourceBuilder> source = new ArrayList<>();
		protected Boolean sCoTASpecifications;
		protected CoalQualityAdjustments.CoalQualityAdjustmentsBuilder btuQualityAdjustment;
		protected CoalQualityAdjustments.CoalQualityAdjustmentsBuilder so2QualityAdjustment;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public CoalProductType.CoalProductTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public CoalProductType.CoalProductTypeBuilder getOrCreateType() {
			CoalProductType.CoalProductTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = CoalProductType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coalProductSpecifications")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coalProductSpecifications")
		public CoalProductSpecifications.CoalProductSpecificationsBuilder getCoalProductSpecifications() {
			return coalProductSpecifications;
		}
		
		@Override
		public CoalProductSpecifications.CoalProductSpecificationsBuilder getOrCreateCoalProductSpecifications() {
			CoalProductSpecifications.CoalProductSpecificationsBuilder result;
			if (coalProductSpecifications!=null) {
				result = coalProductSpecifications;
			}
			else {
				result = coalProductSpecifications = CoalProductSpecifications.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("source")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("source")
		public List<? extends CoalProductSource.CoalProductSourceBuilder> getSource() {
			return source;
		}
		
		@Override
		public CoalProductSource.CoalProductSourceBuilder getOrCreateSource(int index) {
			if (source==null) {
				this.source = new ArrayList<>();
			}
			return getIndex(source, index, () -> {
						CoalProductSource.CoalProductSourceBuilder newSource = CoalProductSource.builder();
						return newSource;
					});
		}
		
		@Override
		@RosettaAttribute("sCoTASpecifications")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sCoTASpecifications")
		public Boolean getSCoTASpecifications() {
			return sCoTASpecifications;
		}
		
		@Override
		@RosettaAttribute("btuQualityAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("btuQualityAdjustment")
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getBtuQualityAdjustment() {
			return btuQualityAdjustment;
		}
		
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getOrCreateBtuQualityAdjustment() {
			CoalQualityAdjustments.CoalQualityAdjustmentsBuilder result;
			if (btuQualityAdjustment!=null) {
				result = btuQualityAdjustment;
			}
			else {
				result = btuQualityAdjustment = CoalQualityAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("so2QualityAdjustment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("so2QualityAdjustment")
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getSo2QualityAdjustment() {
			return so2QualityAdjustment;
		}
		
		@Override
		public CoalQualityAdjustments.CoalQualityAdjustmentsBuilder getOrCreateSo2QualityAdjustment() {
			CoalQualityAdjustments.CoalQualityAdjustmentsBuilder result;
			if (so2QualityAdjustment!=null) {
				result = so2QualityAdjustment;
			}
			else {
				result = so2QualityAdjustment = CoalQualityAdjustments.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public CoalProduct.CoalProductBuilder setType(CoalProductType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coalProductSpecifications")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("coalProductSpecifications")
		@Override
		public CoalProduct.CoalProductBuilder setCoalProductSpecifications(CoalProductSpecifications _coalProductSpecifications) {
			this.coalProductSpecifications = _coalProductSpecifications == null ? null : _coalProductSpecifications.toBuilder();
			return this;
		}
		
		@RosettaAttribute("source")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("source")
		@Override
		public CoalProduct.CoalProductBuilder addSource(CoalProductSource _source) {
			if (_source != null) {
				this.source.add(_source.toBuilder());
			}
			return this;
		}
		
		@Override
		public CoalProduct.CoalProductBuilder addSource(CoalProductSource _source, int idx) {
			getIndex(this.source, idx, () -> _source.toBuilder());
			return this;
		}
		
		@Override
		public CoalProduct.CoalProductBuilder addSource(List<? extends CoalProductSource> sources) {
			if (sources != null) {
				for (final CoalProductSource toAdd : sources) {
					this.source.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("source")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("source")
		@Override
		public CoalProduct.CoalProductBuilder setSource(List<? extends CoalProductSource> sources) {
			if (sources == null) {
				this.source = new ArrayList<>();
			} else {
				this.source = sources.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("sCoTASpecifications")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sCoTASpecifications")
		@Override
		public CoalProduct.CoalProductBuilder setSCoTASpecifications(Boolean _sCoTASpecifications) {
			this.sCoTASpecifications = _sCoTASpecifications == null ? null : _sCoTASpecifications;
			return this;
		}
		
		@RosettaAttribute("btuQualityAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("btuQualityAdjustment")
		@Override
		public CoalProduct.CoalProductBuilder setBtuQualityAdjustment(CoalQualityAdjustments _btuQualityAdjustment) {
			this.btuQualityAdjustment = _btuQualityAdjustment == null ? null : _btuQualityAdjustment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("so2QualityAdjustment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("so2QualityAdjustment")
		@Override
		public CoalProduct.CoalProductBuilder setSo2QualityAdjustment(CoalQualityAdjustments _so2QualityAdjustment) {
			this.so2QualityAdjustment = _so2QualityAdjustment == null ? null : _so2QualityAdjustment.toBuilder();
			return this;
		}
		
		@Override
		public CoalProduct build() {
			return new CoalProduct.CoalProductImpl(this);
		}
		
		@Override
		public CoalProduct.CoalProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalProduct.CoalProductBuilder prune() {
			if (type!=null && !type.prune().hasData()) type = null;
			if (coalProductSpecifications!=null && !coalProductSpecifications.prune().hasData()) coalProductSpecifications = null;
			source = source.stream().filter(b->b!=null).<CoalProductSource.CoalProductSourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (btuQualityAdjustment!=null && !btuQualityAdjustment.prune().hasData()) btuQualityAdjustment = null;
			if (so2QualityAdjustment!=null && !so2QualityAdjustment.prune().hasData()) so2QualityAdjustment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (_getType()!=null && _getType().hasData()) return true;
			if (getCoalProductSpecifications()!=null && getCoalProductSpecifications().hasData()) return true;
			if (getSource()!=null && getSource().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSCoTASpecifications()!=null) return true;
			if (getBtuQualityAdjustment()!=null && getBtuQualityAdjustment().hasData()) return true;
			if (getSo2QualityAdjustment()!=null && getSo2QualityAdjustment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalProduct.CoalProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalProduct.CoalProductBuilder o = (CoalProduct.CoalProductBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			merger.mergeRosetta(getCoalProductSpecifications(), o.getCoalProductSpecifications(), this::setCoalProductSpecifications);
			merger.mergeRosetta(getSource(), o.getSource(), this::getOrCreateSource);
			merger.mergeRosetta(getBtuQualityAdjustment(), o.getBtuQualityAdjustment(), this::setBtuQualityAdjustment);
			merger.mergeRosetta(getSo2QualityAdjustment(), o.getSo2QualityAdjustment(), this::setSo2QualityAdjustment);
			
			merger.mergeBasic(getSCoTASpecifications(), o.getSCoTASpecifications(), this::setSCoTASpecifications);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalProduct _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(coalProductSpecifications, _that.getCoalProductSpecifications())) return false;
			if (!ListEquals.listEquals(source, _that.getSource())) return false;
			if (!Objects.equals(sCoTASpecifications, _that.getSCoTASpecifications())) return false;
			if (!Objects.equals(btuQualityAdjustment, _that.getBtuQualityAdjustment())) return false;
			if (!Objects.equals(so2QualityAdjustment, _that.getSo2QualityAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (coalProductSpecifications != null ? coalProductSpecifications.hashCode() : 0);
			_result = 31 * _result + (source != null ? source.hashCode() : 0);
			_result = 31 * _result + (sCoTASpecifications != null ? sCoTASpecifications.hashCode() : 0);
			_result = 31 * _result + (btuQualityAdjustment != null ? btuQualityAdjustment.hashCode() : 0);
			_result = 31 * _result + (so2QualityAdjustment != null ? so2QualityAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalProductBuilder {" +
				"type=" + this.type + ", " +
				"coalProductSpecifications=" + this.coalProductSpecifications + ", " +
				"source=" + this.source + ", " +
				"sCoTASpecifications=" + this.sCoTASpecifications + ", " +
				"btuQualityAdjustment=" + this.btuQualityAdjustment + ", " +
				"so2QualityAdjustment=" + this.so2QualityAdjustment +
			'}';
		}
	}
}
