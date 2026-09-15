package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.NotionalQuantity9__2Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Indicates the reference quantity of the transaction and the schedule applicable to the quantity computation.
 * @version ${project.version}
 */
@RosettaDataType(value="NotionalQuantity9__2", builder=NotionalQuantity9__2.NotionalQuantity9__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NotionalQuantity9__2", model="iso20022", builder=NotionalQuantity9__2.NotionalQuantity9__2BuilderImpl.class, version="${project.version}")
public interface NotionalQuantity9__2 extends RosettaModelObject {

	NotionalQuantity9__2Meta metaData = new NotionalQuantity9__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Number of units of the financial instrument, that is, the nominal value.
	 */
	BigDecimal getTtlQty();
	/**
	 * Indicates the schedule or frequency of the derivative transactions.
	 */
	QuantityOrTerm1Choice__1 getDtls();

	/*********************** Build Methods  ***********************/
	NotionalQuantity9__2 build();
	
	NotionalQuantity9__2.NotionalQuantity9__2Builder toBuilder();
	
	static NotionalQuantity9__2.NotionalQuantity9__2Builder builder() {
		return new NotionalQuantity9__2.NotionalQuantity9__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalQuantity9__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalQuantity9__2> getType() {
		return NotionalQuantity9__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ttlQty"), BigDecimal.class, getTtlQty(), this);
		processRosetta(path.newSubPath("dtls"), processor, QuantityOrTerm1Choice__1.class, getDtls());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalQuantity9__2Builder extends NotionalQuantity9__2, RosettaModelObjectBuilder {
		QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder getOrCreateDtls();
		@Override
		QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder getDtls();
		NotionalQuantity9__2.NotionalQuantity9__2Builder setTtlQty(BigDecimal ttlQty);
		NotionalQuantity9__2.NotionalQuantity9__2Builder setDtls(QuantityOrTerm1Choice__1 dtls);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ttlQty"), BigDecimal.class, getTtlQty(), this);
			processRosetta(path.newSubPath("dtls"), processor, QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder.class, getDtls());
		}
		

		NotionalQuantity9__2.NotionalQuantity9__2Builder prune();
	}

	/*********************** Immutable Implementation of NotionalQuantity9__2  ***********************/
	class NotionalQuantity9__2Impl implements NotionalQuantity9__2 {
		private final BigDecimal ttlQty;
		private final QuantityOrTerm1Choice__1 dtls;
		
		protected NotionalQuantity9__2Impl(NotionalQuantity9__2.NotionalQuantity9__2Builder builder) {
			this.ttlQty = builder.getTtlQty();
			this.dtls = ofNullable(builder.getDtls()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ttlQty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ttlQty")
		public BigDecimal getTtlQty() {
			return ttlQty;
		}
		
		@Override
		@RosettaAttribute("dtls")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dtls")
		public QuantityOrTerm1Choice__1 getDtls() {
			return dtls;
		}
		
		@Override
		public NotionalQuantity9__2 build() {
			return this;
		}
		
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder toBuilder() {
			NotionalQuantity9__2.NotionalQuantity9__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalQuantity9__2.NotionalQuantity9__2Builder builder) {
			ofNullable(getTtlQty()).ifPresent(builder::setTtlQty);
			ofNullable(getDtls()).ifPresent(builder::setDtls);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalQuantity9__2 _that = getType().cast(o);
		
			if (!Objects.equals(ttlQty, _that.getTtlQty())) return false;
			if (!Objects.equals(dtls, _that.getDtls())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ttlQty != null ? ttlQty.hashCode() : 0);
			_result = 31 * _result + (dtls != null ? dtls.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalQuantity9__2 {" +
				"ttlQty=" + this.ttlQty + ", " +
				"dtls=" + this.dtls +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalQuantity9__2  ***********************/
	class NotionalQuantity9__2BuilderImpl implements NotionalQuantity9__2.NotionalQuantity9__2Builder {
	
		protected BigDecimal ttlQty;
		protected QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder dtls;
		
		@Override
		@RosettaAttribute("ttlQty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ttlQty")
		public BigDecimal getTtlQty() {
			return ttlQty;
		}
		
		@Override
		@RosettaAttribute("dtls")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dtls")
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder getDtls() {
			return dtls;
		}
		
		@Override
		public QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder getOrCreateDtls() {
			QuantityOrTerm1Choice__1.QuantityOrTerm1Choice__1Builder result;
			if (dtls!=null) {
				result = dtls;
			}
			else {
				result = dtls = QuantityOrTerm1Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ttlQty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ttlQty")
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder setTtlQty(BigDecimal _ttlQty) {
			this.ttlQty = _ttlQty == null ? null : _ttlQty;
			return this;
		}
		
		@RosettaAttribute("dtls")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dtls")
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder setDtls(QuantityOrTerm1Choice__1 _dtls) {
			this.dtls = _dtls == null ? null : _dtls.toBuilder();
			return this;
		}
		
		@Override
		public NotionalQuantity9__2 build() {
			return new NotionalQuantity9__2.NotionalQuantity9__2Impl(this);
		}
		
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder prune() {
			if (dtls!=null && !dtls.prune().hasData()) dtls = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTtlQty()!=null) return true;
			if (getDtls()!=null && getDtls().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalQuantity9__2.NotionalQuantity9__2Builder o = (NotionalQuantity9__2.NotionalQuantity9__2Builder) other;
			
			merger.mergeRosetta(getDtls(), o.getDtls(), this::setDtls);
			
			merger.mergeBasic(getTtlQty(), o.getTtlQty(), this::setTtlQty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalQuantity9__2 _that = getType().cast(o);
		
			if (!Objects.equals(ttlQty, _that.getTtlQty())) return false;
			if (!Objects.equals(dtls, _that.getDtls())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ttlQty != null ? ttlQty.hashCode() : 0);
			_result = 31 * _result + (dtls != null ? dtls.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalQuantity9__2Builder {" +
				"ttlQty=" + this.ttlQty + ", " +
				"dtls=" + this.dtls +
			'}';
		}
	}
}
