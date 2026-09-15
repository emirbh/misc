package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.ExchangeRateBasis1Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides information about the exchange rate basis for a foreign exchange transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="ExchangeRateBasis1Choice__1", builder=ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ExchangeRateBasis1Choice__1", model="iso20022", builder=ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1BuilderImpl.class, version="${project.version}")
public interface ExchangeRateBasis1Choice__1 extends RosettaModelObject {

	ExchangeRateBasis1Choice__1Meta metaData = new ExchangeRateBasis1Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Exchange rate basis expressed as a currency pair.
	 */
	ExchangeRateBasis1 getCcyPair();

	/*********************** Build Methods  ***********************/
	ExchangeRateBasis1Choice__1 build();
	
	ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder toBuilder();
	
	static ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder builder() {
		return new ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeRateBasis1Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExchangeRateBasis1Choice__1> getType() {
		return ExchangeRateBasis1Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ccyPair"), processor, ExchangeRateBasis1.class, getCcyPair());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeRateBasis1Choice__1Builder extends ExchangeRateBasis1Choice__1, RosettaModelObjectBuilder {
		ExchangeRateBasis1.ExchangeRateBasis1Builder getOrCreateCcyPair();
		@Override
		ExchangeRateBasis1.ExchangeRateBasis1Builder getCcyPair();
		ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder setCcyPair(ExchangeRateBasis1 ccyPair);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ccyPair"), processor, ExchangeRateBasis1.ExchangeRateBasis1Builder.class, getCcyPair());
		}
		

		ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of ExchangeRateBasis1Choice__1  ***********************/
	class ExchangeRateBasis1Choice__1Impl implements ExchangeRateBasis1Choice__1 {
		private final ExchangeRateBasis1 ccyPair;
		
		protected ExchangeRateBasis1Choice__1Impl(ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder builder) {
			this.ccyPair = ofNullable(builder.getCcyPair()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ccyPair")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ccyPair")
		public ExchangeRateBasis1 getCcyPair() {
			return ccyPair;
		}
		
		@Override
		public ExchangeRateBasis1Choice__1 build() {
			return this;
		}
		
		@Override
		public ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder toBuilder() {
			ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder builder) {
			ofNullable(getCcyPair()).ifPresent(builder::setCcyPair);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeRateBasis1Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(ccyPair, _that.getCcyPair())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ccyPair != null ? ccyPair.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeRateBasis1Choice__1 {" +
				"ccyPair=" + this.ccyPair +
			'}';
		}
	}

	/*********************** Builder Implementation of ExchangeRateBasis1Choice__1  ***********************/
	class ExchangeRateBasis1Choice__1BuilderImpl implements ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder {
	
		protected ExchangeRateBasis1.ExchangeRateBasis1Builder ccyPair;
		
		@Override
		@RosettaAttribute("ccyPair")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ccyPair")
		public ExchangeRateBasis1.ExchangeRateBasis1Builder getCcyPair() {
			return ccyPair;
		}
		
		@Override
		public ExchangeRateBasis1.ExchangeRateBasis1Builder getOrCreateCcyPair() {
			ExchangeRateBasis1.ExchangeRateBasis1Builder result;
			if (ccyPair!=null) {
				result = ccyPair;
			}
			else {
				result = ccyPair = ExchangeRateBasis1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ccyPair")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ccyPair")
		@Override
		public ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder setCcyPair(ExchangeRateBasis1 _ccyPair) {
			this.ccyPair = _ccyPair == null ? null : _ccyPair.toBuilder();
			return this;
		}
		
		@Override
		public ExchangeRateBasis1Choice__1 build() {
			return new ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Impl(this);
		}
		
		@Override
		public ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder prune() {
			if (ccyPair!=null && !ccyPair.prune().hasData()) ccyPair = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCcyPair()!=null && getCcyPair().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder o = (ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder) other;
			
			merger.mergeRosetta(getCcyPair(), o.getCcyPair(), this::setCcyPair);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExchangeRateBasis1Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(ccyPair, _that.getCcyPair())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ccyPair != null ? ccyPair.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeRateBasis1Choice__1Builder {" +
				"ccyPair=" + this.ccyPair +
			'}';
		}
	}
}
