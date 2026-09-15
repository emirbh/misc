package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.SecuritiesTransactionPrice14Choice__1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SecuritiesTransactionPrice14Choice__1", builder=SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="SecuritiesTransactionPrice14Choice__1", model="iso20022", builder=SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1BuilderImpl.class, version="${project.version}")
public interface SecuritiesTransactionPrice14Choice__1 extends RosettaModelObject {

	SecuritiesTransactionPrice14Choice__1Meta metaData = new SecuritiesTransactionPrice14Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getDcml();

	/*********************** Build Methods  ***********************/
	SecuritiesTransactionPrice14Choice__1 build();
	
	SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder toBuilder();
	
	static SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder builder() {
		return new SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecuritiesTransactionPrice14Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecuritiesTransactionPrice14Choice__1> getType() {
		return SecuritiesTransactionPrice14Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dcml"), BigDecimal.class, getDcml(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecuritiesTransactionPrice14Choice__1Builder extends SecuritiesTransactionPrice14Choice__1, RosettaModelObjectBuilder {
		SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder setDcml(BigDecimal dcml);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dcml"), BigDecimal.class, getDcml(), this);
		}
		

		SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of SecuritiesTransactionPrice14Choice__1  ***********************/
	class SecuritiesTransactionPrice14Choice__1Impl implements SecuritiesTransactionPrice14Choice__1 {
		private final BigDecimal dcml;
		
		protected SecuritiesTransactionPrice14Choice__1Impl(SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder builder) {
			this.dcml = builder.getDcml();
		}
		
		@Override
		@RosettaAttribute("dcml")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dcml")
		public BigDecimal getDcml() {
			return dcml;
		}
		
		@Override
		public SecuritiesTransactionPrice14Choice__1 build() {
			return this;
		}
		
		@Override
		public SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder toBuilder() {
			SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder builder) {
			ofNullable(getDcml()).ifPresent(builder::setDcml);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuritiesTransactionPrice14Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(dcml, _that.getDcml())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dcml != null ? dcml.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuritiesTransactionPrice14Choice__1 {" +
				"dcml=" + this.dcml +
			'}';
		}
	}

	/*********************** Builder Implementation of SecuritiesTransactionPrice14Choice__1  ***********************/
	class SecuritiesTransactionPrice14Choice__1BuilderImpl implements SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder {
	
		protected BigDecimal dcml;
		
		@Override
		@RosettaAttribute("dcml")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dcml")
		public BigDecimal getDcml() {
			return dcml;
		}
		
		@RosettaAttribute("dcml")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dcml")
		@Override
		public SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder setDcml(BigDecimal _dcml) {
			this.dcml = _dcml == null ? null : _dcml;
			return this;
		}
		
		@Override
		public SecuritiesTransactionPrice14Choice__1 build() {
			return new SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Impl(this);
		}
		
		@Override
		public SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDcml()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder o = (SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder) other;
			
			
			merger.mergeBasic(getDcml(), o.getDcml(), this::setDcml);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuritiesTransactionPrice14Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(dcml, _that.getDcml())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dcml != null ? dcml.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuritiesTransactionPrice14Choice__1Builder {" +
				"dcml=" + this.dcml +
			'}';
		}
	}
}
