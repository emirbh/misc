package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.ExchangeRateBasis1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides information about the terms of the foreign exchange transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="ExchangeRateBasis1", builder=ExchangeRateBasis1.ExchangeRateBasis1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ExchangeRateBasis1", model="iso20022", builder=ExchangeRateBasis1.ExchangeRateBasis1BuilderImpl.class, version="${project.version}")
public interface ExchangeRateBasis1 extends RosettaModelObject {

	ExchangeRateBasis1Meta metaData = new ExchangeRateBasis1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Currency in which the rate of exchange is expressed in a currency exchange.  Usage: In the example one GBP equals xxxUSD, the unit currency is GBP.
	 */
	String getBaseCcy();
	/**
	 * Currency into which the base currency is converted, in a currency exchange.
	 */
	String getQtdCcy();

	/*********************** Build Methods  ***********************/
	ExchangeRateBasis1 build();
	
	ExchangeRateBasis1.ExchangeRateBasis1Builder toBuilder();
	
	static ExchangeRateBasis1.ExchangeRateBasis1Builder builder() {
		return new ExchangeRateBasis1.ExchangeRateBasis1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeRateBasis1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExchangeRateBasis1> getType() {
		return ExchangeRateBasis1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("baseCcy"), String.class, getBaseCcy(), this);
		processor.processBasic(path.newSubPath("qtdCcy"), String.class, getQtdCcy(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeRateBasis1Builder extends ExchangeRateBasis1, RosettaModelObjectBuilder {
		ExchangeRateBasis1.ExchangeRateBasis1Builder setBaseCcy(String baseCcy);
		ExchangeRateBasis1.ExchangeRateBasis1Builder setQtdCcy(String qtdCcy);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("baseCcy"), String.class, getBaseCcy(), this);
			processor.processBasic(path.newSubPath("qtdCcy"), String.class, getQtdCcy(), this);
		}
		

		ExchangeRateBasis1.ExchangeRateBasis1Builder prune();
	}

	/*********************** Immutable Implementation of ExchangeRateBasis1  ***********************/
	class ExchangeRateBasis1Impl implements ExchangeRateBasis1 {
		private final String baseCcy;
		private final String qtdCcy;
		
		protected ExchangeRateBasis1Impl(ExchangeRateBasis1.ExchangeRateBasis1Builder builder) {
			this.baseCcy = builder.getBaseCcy();
			this.qtdCcy = builder.getQtdCcy();
		}
		
		@Override
		@RosettaAttribute("baseCcy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("baseCcy")
		public String getBaseCcy() {
			return baseCcy;
		}
		
		@Override
		@RosettaAttribute("qtdCcy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("qtdCcy")
		public String getQtdCcy() {
			return qtdCcy;
		}
		
		@Override
		public ExchangeRateBasis1 build() {
			return this;
		}
		
		@Override
		public ExchangeRateBasis1.ExchangeRateBasis1Builder toBuilder() {
			ExchangeRateBasis1.ExchangeRateBasis1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeRateBasis1.ExchangeRateBasis1Builder builder) {
			ofNullable(getBaseCcy()).ifPresent(builder::setBaseCcy);
			ofNullable(getQtdCcy()).ifPresent(builder::setQtdCcy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeRateBasis1 _that = getType().cast(o);
		
			if (!Objects.equals(baseCcy, _that.getBaseCcy())) return false;
			if (!Objects.equals(qtdCcy, _that.getQtdCcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (baseCcy != null ? baseCcy.hashCode() : 0);
			_result = 31 * _result + (qtdCcy != null ? qtdCcy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeRateBasis1 {" +
				"baseCcy=" + this.baseCcy + ", " +
				"qtdCcy=" + this.qtdCcy +
			'}';
		}
	}

	/*********************** Builder Implementation of ExchangeRateBasis1  ***********************/
	class ExchangeRateBasis1BuilderImpl implements ExchangeRateBasis1.ExchangeRateBasis1Builder {
	
		protected String baseCcy;
		protected String qtdCcy;
		
		@Override
		@RosettaAttribute("baseCcy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("baseCcy")
		public String getBaseCcy() {
			return baseCcy;
		}
		
		@Override
		@RosettaAttribute("qtdCcy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("qtdCcy")
		public String getQtdCcy() {
			return qtdCcy;
		}
		
		@RosettaAttribute("baseCcy")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("baseCcy")
		@Override
		public ExchangeRateBasis1.ExchangeRateBasis1Builder setBaseCcy(String _baseCcy) {
			this.baseCcy = _baseCcy == null ? null : _baseCcy;
			return this;
		}
		
		@RosettaAttribute("qtdCcy")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("qtdCcy")
		@Override
		public ExchangeRateBasis1.ExchangeRateBasis1Builder setQtdCcy(String _qtdCcy) {
			this.qtdCcy = _qtdCcy == null ? null : _qtdCcy;
			return this;
		}
		
		@Override
		public ExchangeRateBasis1 build() {
			return new ExchangeRateBasis1.ExchangeRateBasis1Impl(this);
		}
		
		@Override
		public ExchangeRateBasis1.ExchangeRateBasis1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeRateBasis1.ExchangeRateBasis1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBaseCcy()!=null) return true;
			if (getQtdCcy()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeRateBasis1.ExchangeRateBasis1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExchangeRateBasis1.ExchangeRateBasis1Builder o = (ExchangeRateBasis1.ExchangeRateBasis1Builder) other;
			
			
			merger.mergeBasic(getBaseCcy(), o.getBaseCcy(), this::setBaseCcy);
			merger.mergeBasic(getQtdCcy(), o.getQtdCcy(), this::setQtdCcy);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeRateBasis1 _that = getType().cast(o);
		
			if (!Objects.equals(baseCcy, _that.getBaseCcy())) return false;
			if (!Objects.equals(qtdCcy, _that.getQtdCcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (baseCcy != null ? baseCcy.hashCode() : 0);
			_result = 31 * _result + (qtdCcy != null ? qtdCcy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeRateBasis1Builder {" +
				"baseCcy=" + this.baseCcy + ", " +
				"qtdCcy=" + this.qtdCcy +
			'}';
		}
	}
}
