package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityLegMeta;
import fpml.consolidated.shared.Leg;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Abstract base class for all commodity legs
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Abstract base class for all commodity legs
 *
 */
@RosettaDataType(value="CommodityLeg", builder=CommodityLeg.CommodityLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityLeg", model="fpml", builder=CommodityLeg.CommodityLegBuilderImpl.class, version="2.1.1")
public interface CommodityLeg extends Leg {

	CommodityLegMeta metaData = new CommodityLegMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CommodityLeg build();
	
	CommodityLeg.CommodityLegBuilder toBuilder();
	
	static CommodityLeg.CommodityLegBuilder builder() {
		return new CommodityLeg.CommodityLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityLeg> getType() {
		return CommodityLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityLegBuilder extends CommodityLeg, Leg.LegBuilder {
		@Override
		CommodityLeg.CommodityLegBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommodityLeg.CommodityLegBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityLeg  ***********************/
	class CommodityLegImpl extends Leg.LegImpl implements CommodityLeg {
		
		protected CommodityLegImpl(CommodityLeg.CommodityLegBuilder builder) {
			super(builder);
		}
		
		@Override
		public CommodityLeg build() {
			return this;
		}
		
		@Override
		public CommodityLeg.CommodityLegBuilder toBuilder() {
			CommodityLeg.CommodityLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityLeg.CommodityLegBuilder builder) {
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
			return "CommodityLeg {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityLeg  ***********************/
	class CommodityLegBuilderImpl extends Leg.LegBuilderImpl implements CommodityLeg.CommodityLegBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityLeg.CommodityLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public CommodityLeg build() {
			return new CommodityLeg.CommodityLegImpl(this);
		}
		
		@Override
		public CommodityLeg.CommodityLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityLeg.CommodityLegBuilder prune() {
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
		public CommodityLeg.CommodityLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityLeg.CommodityLegBuilder o = (CommodityLeg.CommodityLegBuilder) other;
			
			
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
			return "CommodityLegBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
