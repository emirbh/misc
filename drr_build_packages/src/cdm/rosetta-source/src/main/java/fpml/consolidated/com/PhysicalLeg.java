package fpml.consolidated.com;

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
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.meta.PhysicalLegMeta;
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
 * Provision Physical Commodity Leg.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Physical Commodity Leg.
 *
 */
@RosettaDataType(value="PhysicalLeg", builder=PhysicalLeg.PhysicalLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PhysicalLeg", model="fpml", builder=PhysicalLeg.PhysicalLegBuilderImpl.class, version="2.1.1")
public interface PhysicalLeg extends PhysicalLegBase {

	PhysicalLegMeta metaData = new PhysicalLegMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	PhysicalLeg build();
	
	PhysicalLeg.PhysicalLegBuilder toBuilder();
	
	static PhysicalLeg.PhysicalLegBuilder builder() {
		return new PhysicalLeg.PhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PhysicalLeg> getType() {
		return PhysicalLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.class, getCommodityClassification());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PhysicalLegBuilder extends PhysicalLeg, PhysicalLegBase.PhysicalLegBaseBuilder {
		@Override
		PhysicalLeg.PhysicalLegBuilder setId(String id);
		@Override
		PhysicalLeg.PhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification);
		@Override
		PhysicalLeg.PhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification, int idx);
		@Override
		PhysicalLeg.PhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		PhysicalLeg.PhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassification);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.CommodityClassificationBuilder.class, getCommodityClassification());
		}
		

		PhysicalLeg.PhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of PhysicalLeg  ***********************/
	class PhysicalLegImpl extends PhysicalLegBase.PhysicalLegBaseImpl implements PhysicalLeg {
		
		protected PhysicalLegImpl(PhysicalLeg.PhysicalLegBuilder builder) {
			super(builder);
		}
		
		@Override
		public PhysicalLeg build() {
			return this;
		}
		
		@Override
		public PhysicalLeg.PhysicalLegBuilder toBuilder() {
			PhysicalLeg.PhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PhysicalLeg.PhysicalLegBuilder builder) {
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
			return "PhysicalLeg {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PhysicalLeg  ***********************/
	class PhysicalLegBuilderImpl extends PhysicalLegBase.PhysicalLegBaseBuilderImpl implements PhysicalLeg.PhysicalLegBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PhysicalLeg.PhysicalLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public PhysicalLeg.PhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification) {
			if (_commodityClassification != null) {
				this.commodityClassification.add(_commodityClassification.toBuilder());
			}
			return this;
		}
		
		@Override
		public PhysicalLeg.PhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification, int idx) {
			getIndex(this.commodityClassification, idx, () -> _commodityClassification.toBuilder());
			return this;
		}
		
		@Override
		public PhysicalLeg.PhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
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
		public PhysicalLeg.PhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
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
		public PhysicalLeg build() {
			return new PhysicalLeg.PhysicalLegImpl(this);
		}
		
		@Override
		public PhysicalLeg.PhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PhysicalLeg.PhysicalLegBuilder prune() {
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
		public PhysicalLeg.PhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PhysicalLeg.PhysicalLegBuilder o = (PhysicalLeg.PhysicalLegBuilder) other;
			
			
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
			return "PhysicalLegBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
