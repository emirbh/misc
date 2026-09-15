package drr.standards.iosco.upi;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import drr.standards.iosco.upi.meta.AnnaDsbSingleStockMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbSingleStock", builder=AnnaDsbSingleStock.AnnaDsbSingleStockBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbSingleStock", model="drr", builder=AnnaDsbSingleStock.AnnaDsbSingleStockBuilderImpl.class, version="7.7.0")
public interface AnnaDsbSingleStock extends RosettaModelObject {

	AnnaDsbSingleStockMeta metaData = new AnnaDsbSingleStockMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource();
	String getUnderlierID();

	/*********************** Build Methods  ***********************/
	AnnaDsbSingleStock build();
	
	AnnaDsbSingleStock.AnnaDsbSingleStockBuilder toBuilder();
	
	static AnnaDsbSingleStock.AnnaDsbSingleStockBuilder builder() {
		return new AnnaDsbSingleStock.AnnaDsbSingleStockBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbSingleStock> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbSingleStock> getType() {
		return AnnaDsbSingleStock.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
		processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbSingleStockBuilder extends AnnaDsbSingleStock, RosettaModelObjectBuilder {
		AnnaDsbSingleStock.AnnaDsbSingleStockBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum UnderlierIDSource);
		AnnaDsbSingleStock.AnnaDsbSingleStockBuilder setUnderlierID(String UnderlierID);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
		}
		

		AnnaDsbSingleStock.AnnaDsbSingleStockBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbSingleStock  ***********************/
	class AnnaDsbSingleStockImpl implements AnnaDsbSingleStock {
		private final AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		private final String underlierID;
		
		protected AnnaDsbSingleStockImpl(AnnaDsbSingleStock.AnnaDsbSingleStockBuilder builder) {
			this.underlierIDSource = builder.getUnderlierIDSource();
			this.underlierID = builder.getUnderlierID();
		}
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierID")
		public String getUnderlierID() {
			return underlierID;
		}
		
		@Override
		public AnnaDsbSingleStock build() {
			return this;
		}
		
		@Override
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder toBuilder() {
			AnnaDsbSingleStock.AnnaDsbSingleStockBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbSingleStock.AnnaDsbSingleStockBuilder builder) {
			ofNullable(getUnderlierIDSource()).ifPresent(builder::setUnderlierIDSource);
			ofNullable(getUnderlierID()).ifPresent(builder::setUnderlierID);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbSingleStock _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbSingleStock {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"UnderlierID=" + this.underlierID +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbSingleStock  ***********************/
	class AnnaDsbSingleStockBuilderImpl implements AnnaDsbSingleStock.AnnaDsbSingleStockBuilder {
	
		protected AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		protected String underlierID;
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UnderlierID")
		public String getUnderlierID() {
			return underlierID;
		}
		
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlierIDSource")
		@Override
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum _underlierIDSource) {
			this.underlierIDSource = _underlierIDSource == null ? null : _underlierIDSource;
			return this;
		}
		
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UnderlierID")
		@Override
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder setUnderlierID(String _underlierID) {
			this.underlierID = _underlierID == null ? null : _underlierID;
			return this;
		}
		
		@Override
		public AnnaDsbSingleStock build() {
			return new AnnaDsbSingleStock.AnnaDsbSingleStockImpl(this);
		}
		
		@Override
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnderlierIDSource()!=null) return true;
			if (getUnderlierID()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbSingleStock.AnnaDsbSingleStockBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbSingleStock.AnnaDsbSingleStockBuilder o = (AnnaDsbSingleStock.AnnaDsbSingleStockBuilder) other;
			
			
			merger.mergeBasic(getUnderlierIDSource(), o.getUnderlierIDSource(), this::setUnderlierIDSource);
			merger.mergeBasic(getUnderlierID(), o.getUnderlierID(), this::setUnderlierID);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbSingleStock _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbSingleStockBuilder {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"UnderlierID=" + this.underlierID +
			'}';
		}
	}
}
