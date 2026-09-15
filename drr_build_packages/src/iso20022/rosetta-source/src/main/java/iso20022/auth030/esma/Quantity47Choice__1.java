package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.Quantity47Choice__1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the format of the quantity of delivery.
 * @version ${project.version}
 */
@RosettaDataType(value="Quantity47Choice__1", builder=Quantity47Choice__1.Quantity47Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Quantity47Choice__1", model="iso20022", builder=Quantity47Choice__1.Quantity47Choice__1BuilderImpl.class, version="${project.version}")
public interface Quantity47Choice__1 extends RosettaModelObject {

	Quantity47Choice__1Meta metaData = new Quantity47Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Quantity of delivery.
	 */
	BigDecimal getQty();

	/*********************** Build Methods  ***********************/
	Quantity47Choice__1 build();
	
	Quantity47Choice__1.Quantity47Choice__1Builder toBuilder();
	
	static Quantity47Choice__1.Quantity47Choice__1Builder builder() {
		return new Quantity47Choice__1.Quantity47Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Quantity47Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Quantity47Choice__1> getType() {
		return Quantity47Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("qty"), BigDecimal.class, getQty(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface Quantity47Choice__1Builder extends Quantity47Choice__1, RosettaModelObjectBuilder {
		Quantity47Choice__1.Quantity47Choice__1Builder setQty(BigDecimal qty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("qty"), BigDecimal.class, getQty(), this);
		}
		

		Quantity47Choice__1.Quantity47Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of Quantity47Choice__1  ***********************/
	class Quantity47Choice__1Impl implements Quantity47Choice__1 {
		private final BigDecimal qty;
		
		protected Quantity47Choice__1Impl(Quantity47Choice__1.Quantity47Choice__1Builder builder) {
			this.qty = builder.getQty();
		}
		
		@Override
		@RosettaAttribute("qty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("qty")
		public BigDecimal getQty() {
			return qty;
		}
		
		@Override
		public Quantity47Choice__1 build() {
			return this;
		}
		
		@Override
		public Quantity47Choice__1.Quantity47Choice__1Builder toBuilder() {
			Quantity47Choice__1.Quantity47Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Quantity47Choice__1.Quantity47Choice__1Builder builder) {
			ofNullable(getQty()).ifPresent(builder::setQty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Quantity47Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(qty, _that.getQty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (qty != null ? qty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Quantity47Choice__1 {" +
				"qty=" + this.qty +
			'}';
		}
	}

	/*********************** Builder Implementation of Quantity47Choice__1  ***********************/
	class Quantity47Choice__1BuilderImpl implements Quantity47Choice__1.Quantity47Choice__1Builder {
	
		protected BigDecimal qty;
		
		@Override
		@RosettaAttribute("qty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("qty")
		public BigDecimal getQty() {
			return qty;
		}
		
		@RosettaAttribute("qty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("qty")
		@Override
		public Quantity47Choice__1.Quantity47Choice__1Builder setQty(BigDecimal _qty) {
			this.qty = _qty == null ? null : _qty;
			return this;
		}
		
		@Override
		public Quantity47Choice__1 build() {
			return new Quantity47Choice__1.Quantity47Choice__1Impl(this);
		}
		
		@Override
		public Quantity47Choice__1.Quantity47Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Quantity47Choice__1.Quantity47Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Quantity47Choice__1.Quantity47Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Quantity47Choice__1.Quantity47Choice__1Builder o = (Quantity47Choice__1.Quantity47Choice__1Builder) other;
			
			
			merger.mergeBasic(getQty(), o.getQty(), this::setQty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Quantity47Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(qty, _that.getQty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (qty != null ? qty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Quantity47Choice__1Builder {" +
				"qty=" + this.qty +
			'}';
		}
	}
}
