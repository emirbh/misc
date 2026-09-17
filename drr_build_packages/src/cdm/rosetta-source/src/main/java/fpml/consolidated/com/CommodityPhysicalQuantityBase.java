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
import fpml.consolidated.com.meta.CommodityPhysicalQuantityBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision An abstract base class for physical quantity types.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An abstract base class for physical quantity types.
 *
 */
@RosettaDataType(value="CommodityPhysicalQuantityBase", builder=CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityPhysicalQuantityBase", model="fpml", builder=CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilderImpl.class, version="2.1.1")
public interface CommodityPhysicalQuantityBase extends RosettaModelObject {

	CommodityPhysicalQuantityBaseMeta metaData = new CommodityPhysicalQuantityBaseMeta();

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
	String getId();

	/*********************** Build Methods  ***********************/
	CommodityPhysicalQuantityBase build();
	
	CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder toBuilder();
	
	static CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder builder() {
		return new CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPhysicalQuantityBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityPhysicalQuantityBase> getType() {
		return CommodityPhysicalQuantityBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPhysicalQuantityBaseBuilder extends CommodityPhysicalQuantityBase, RosettaModelObjectBuilder {
		CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPhysicalQuantityBase  ***********************/
	class CommodityPhysicalQuantityBaseImpl implements CommodityPhysicalQuantityBase {
		private final String id;
		
		protected CommodityPhysicalQuantityBaseImpl(CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder builder) {
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CommodityPhysicalQuantityBase build() {
			return this;
		}
		
		@Override
		public CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder toBuilder() {
			CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalQuantityBase _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalQuantityBase {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPhysicalQuantityBase  ***********************/
	class CommodityPhysicalQuantityBaseBuilderImpl implements CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder {
	
		protected String id;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public CommodityPhysicalQuantityBase build() {
			return new CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseImpl(this);
		}
		
		@Override
		public CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder o = (CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalQuantityBase _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalQuantityBaseBuilder {" +
				"id=" + this.id +
			'}';
		}
	}
}
