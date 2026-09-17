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
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.meta.PhysicalLegBaseMeta;
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
@RosettaDataType(value="PhysicalLegBase", builder=PhysicalLegBase.PhysicalLegBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PhysicalLegBase", model="fpml", builder=PhysicalLegBase.PhysicalLegBaseBuilderImpl.class, version="2.1.1")
public interface PhysicalLegBase extends CommodityLeg {

	PhysicalLegBaseMeta metaData = new PhysicalLegBaseMeta();

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
	List<? extends CommodityClassification> getCommodityClassification();

	/*********************** Build Methods  ***********************/
	PhysicalLegBase build();
	
	PhysicalLegBase.PhysicalLegBaseBuilder toBuilder();
	
	static PhysicalLegBase.PhysicalLegBaseBuilder builder() {
		return new PhysicalLegBase.PhysicalLegBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PhysicalLegBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PhysicalLegBase> getType() {
		return PhysicalLegBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.class, getCommodityClassification());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PhysicalLegBaseBuilder extends PhysicalLegBase, CommodityLeg.CommodityLegBuilder {
		CommodityClassification.CommodityClassificationBuilder getOrCreateCommodityClassification(int index);
		@Override
		List<? extends CommodityClassification.CommodityClassificationBuilder> getCommodityClassification();
		@Override
		PhysicalLegBase.PhysicalLegBaseBuilder setId(String id);
		PhysicalLegBase.PhysicalLegBaseBuilder addCommodityClassification(CommodityClassification commodityClassification);
		PhysicalLegBase.PhysicalLegBaseBuilder addCommodityClassification(CommodityClassification commodityClassification, int idx);
		PhysicalLegBase.PhysicalLegBaseBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		PhysicalLegBase.PhysicalLegBaseBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassification);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.CommodityClassificationBuilder.class, getCommodityClassification());
		}
		

		PhysicalLegBase.PhysicalLegBaseBuilder prune();
	}

	/*********************** Immutable Implementation of PhysicalLegBase  ***********************/
	class PhysicalLegBaseImpl extends CommodityLeg.CommodityLegImpl implements PhysicalLegBase {
		private final List<? extends CommodityClassification> commodityClassification;
		
		protected PhysicalLegBaseImpl(PhysicalLegBase.PhysicalLegBaseBuilder builder) {
			super(builder);
			this.commodityClassification = ofNullable(builder.getCommodityClassification()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("commodityClassification")
		public List<? extends CommodityClassification> getCommodityClassification() {
			return commodityClassification;
		}
		
		@Override
		public PhysicalLegBase build() {
			return this;
		}
		
		@Override
		public PhysicalLegBase.PhysicalLegBaseBuilder toBuilder() {
			PhysicalLegBase.PhysicalLegBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PhysicalLegBase.PhysicalLegBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodityClassification()).ifPresent(builder::setCommodityClassification);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PhysicalLegBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(commodityClassification, _that.getCommodityClassification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityClassification != null ? commodityClassification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PhysicalLegBase {" +
				"commodityClassification=" + this.commodityClassification +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PhysicalLegBase  ***********************/
	class PhysicalLegBaseBuilderImpl extends CommodityLeg.CommodityLegBuilderImpl implements PhysicalLegBase.PhysicalLegBaseBuilder {
	
		protected List<CommodityClassification.CommodityClassificationBuilder> commodityClassification = new ArrayList<>();
		
		@Override
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("commodityClassification")
		public List<? extends CommodityClassification.CommodityClassificationBuilder> getCommodityClassification() {
			return commodityClassification;
		}
		
		@Override
		public CommodityClassification.CommodityClassificationBuilder getOrCreateCommodityClassification(int index) {
			if (commodityClassification==null) {
				this.commodityClassification = new ArrayList<>();
			}
			return getIndex(commodityClassification, index, () -> {
						CommodityClassification.CommodityClassificationBuilder newCommodityClassification = CommodityClassification.builder();
						return newCommodityClassification;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PhysicalLegBase.PhysicalLegBaseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public PhysicalLegBase.PhysicalLegBaseBuilder addCommodityClassification(CommodityClassification _commodityClassification) {
			if (_commodityClassification != null) {
				this.commodityClassification.add(_commodityClassification.toBuilder());
			}
			return this;
		}
		
		@Override
		public PhysicalLegBase.PhysicalLegBaseBuilder addCommodityClassification(CommodityClassification _commodityClassification, int idx) {
			getIndex(this.commodityClassification, idx, () -> _commodityClassification.toBuilder());
			return this;
		}
		
		@Override
		public PhysicalLegBase.PhysicalLegBaseBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
			if (commodityClassifications != null) {
				for (final CommodityClassification toAdd : commodityClassifications) {
					this.commodityClassification.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public PhysicalLegBase.PhysicalLegBaseBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
			if (commodityClassifications == null) {
				this.commodityClassification = new ArrayList<>();
			} else {
				this.commodityClassification = commodityClassifications.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PhysicalLegBase build() {
			return new PhysicalLegBase.PhysicalLegBaseImpl(this);
		}
		
		@Override
		public PhysicalLegBase.PhysicalLegBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PhysicalLegBase.PhysicalLegBaseBuilder prune() {
			super.prune();
			commodityClassification = commodityClassification.stream().filter(b->b!=null).<CommodityClassification.CommodityClassificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodityClassification()!=null && getCommodityClassification().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PhysicalLegBase.PhysicalLegBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PhysicalLegBase.PhysicalLegBaseBuilder o = (PhysicalLegBase.PhysicalLegBaseBuilder) other;
			
			merger.mergeRosetta(getCommodityClassification(), o.getCommodityClassification(), this::getOrCreateCommodityClassification);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PhysicalLegBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(commodityClassification, _that.getCommodityClassification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityClassification != null ? commodityClassification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PhysicalLegBaseBuilder {" +
				"commodityClassification=" + this.commodityClassification +
			'}' + " " + super.toString();
		}
	}
}
